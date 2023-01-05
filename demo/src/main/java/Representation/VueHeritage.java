package Representation;

import javafx.scene.shape.Line;

public class VueHeritage extends VueRelation{

    private Line pointeC;
    private Heritage herit;

    public VueHeritage(Heritage h){
        herit = h;
    }

    public void actualiser(){
        xDebut = herit.getXDebut();
        yDebut = herit.getYDebut();
        xFin = herit.getXFin();
        yFin = herit.getYFin();

        int xS =5;
        int yS =5;
        if(xDebut>xFin){
            xS = -5;
        }
        if(yDebut>yFin){
            yS = -5;
        }

        if(yDebut == yFin){
            chemin = new Line(xDebut,yDebut,xFin-(xS*2),yFin);
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin-(xS*2),yFin+(yS*2));
            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin-(xS*2),yFin+(yS*2));
        }else if(xDebut == xFin){
            chemin = new Line(xDebut,yDebut,xFin,yFin-(yS*2));
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin+(xS*2),yFin-(yS*2));
            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin+(xS*2),yFin-(yS*2));
        }else {
            chemin = new Line(xDebut,yDebut,xFin-xS,yFin-yS);
            pointeA = new Line(xFin, yFin, xFin - (xS * 2), yFin);
            pointeB = new Line(xFin, yFin, xFin, yFin - (yS * 2));
            pointeC = new Line(xFin - (xS * 2), yFin, xFin, yFin - (yS * 2));
        }

        getChildren().addAll(chemin,pointeA,pointeB,pointeC);
    }
}
