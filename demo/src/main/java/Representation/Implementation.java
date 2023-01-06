package Representation;

import Vue.VueImplementation;
import Vue.VueRelation;
import javafx.scene.shape.Line;

public class Implementation extends Relation {
    private Line pointeC;

    public Implementation(Instance src, Instance cible) {
        super(src, cible);
    }

    public Implementation(int xd, int yd, int xf, int yf){
        super(xd,yd,xf,yf);
        this.update();
    }

    public void update(){
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

            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin-(xS*2),yFin+(yS*2));
        }else if(xDebut == xFin){

            pointeC = new Line(xFin-(xS*2),yFin-(yS*2),xFin+(xS*2),yFin-(yS*2));
        }else {
            pointeC = new Line(xFin - (xS * 2), yFin, xFin, yFin - (yS * 2));
        }
    }

    @Override
    public String toString() {
        return "la classe "+this.cleaner(this.classeSrc.getC())+" implemente l'interface "+this.cleaner(this.classeCible.getC());
    }

    @Override
    public VueRelation getImage() {
        return new VueImplementation(this);
    }
}
