package Representation;

import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class VueAssociation extends VueRelation{
    private Text textD;
    private Text textF;
    private Association assoc;

    public VueAssociation(Association a){
        assoc = a;
    }

    public void actualiser(){
        textD = new Text(assoc.getNbSrc());
        textF = new Text(assoc.getNbCible());
        xDebut = assoc.getXDebut();
        yDebut = assoc.getYDebut();
        xFin = assoc.getXFin();
        yFin = assoc.getYFin();

        int xS =5;
        int yS =5;
        if(xDebut>xFin){
            xS = -5;
        }
        if(yDebut>yFin){
            yS = -5;
        }

        chemin = new Line(xDebut,yDebut,xFin,yFin);
        textD.setX(xDebut+xS);
        textD.setY(yDebut-yS);
        textF.setX(xFin-xS);
        textF.setY(yFin-yS);

        if(yDebut == yFin){
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin-(xS*2),yFin+(yS*2));
        }else if(xDebut == xFin){
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin+(xS*2),yFin-(yS*2));
        }else {
            pointeA = new Line(xFin, yFin, xFin - (xS * 2), yFin);
            pointeB = new Line(xFin, yFin, xFin, yFin - (yS * 2));
        }

        getChildren().addAll(chemin,pointeA,pointeB,textD,textF);
    }
}
