package Representation;

import javafx.scene.shape.Line;

public class VueImplementation extends VueRelation {
    private Line pointeC;
    private Implementation imple;

    public VueImplementation(Implementation i){
        imple = i;
    }

    public void actualiser(){
        xDebut = imple.getXDebut();
        yDebut = imple.getYDebut();
        xFin = imple.getXFin();
        yFin = imple.getYFin();

        int xS =5;
        int yS =5;
        int longueur = (xDebut - xFin) /20;
        int hauteur = (yDebut - yFin) /20;

        if(xDebut>xFin){
            xS = -5;
        }
        if(yDebut>yFin){
            yS = -5;
        }


        if(yDebut == yFin){
            chemin = new Line(xDebut,yDebut,xFin-(xS*2),yFin);
            chemin.getStrokeDashArray().addAll(10d);
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin-(xS*2),yFin+(yS*2));
            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin-(xS*2),yFin+(yS*2));
        }else if(xDebut == xFin){
            chemin = new Line(xDebut,yDebut,xFin,yFin-(yS*2));
            chemin.getStrokeDashArray().addAll(10d);
            pointeA = new Line(xFin,yFin,xFin-(xS*2),yFin-(yS*2));
            pointeB = new Line(xFin,yFin,xFin+(xS*2),yFin-(yS*2));
            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin+(xS*2),yFin-(yS*2));
        }else {
            chemin = new Line(xDebut,yDebut,xFin-xS,yFin-yS);
            chemin.getStrokeDashArray().addAll(5d);
            pointeA = new Line(xFin, yFin, xFin - (xS * 2), yFin);
            pointeB = new Line(xFin, yFin, xFin, yFin - (yS * 2));
            pointeC = new Line(xFin - (xS * 2), yFin, xFin, yFin - (yS * 2));
        }

        getChildren().addAll(chemin,pointeA,pointeB,pointeC);
    }
}
