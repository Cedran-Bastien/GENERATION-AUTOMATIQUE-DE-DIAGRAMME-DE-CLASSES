package Representation;

import Vue.VueHeritage;
import Vue.VueRelation;
import javafx.scene.shape.Line;

public class Heritage extends Relation{
    private Line pointeC;

    public Heritage( Instance cible) {
        super(cible);
    }

    public Heritage(int xd, int yd, int xf, int yf){
        super(xd,yd,xf,yf);
        this.update();
    }

    public void update(){
        int xS =5;
        int yS =5;
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
        return " herite de la classe "+this.cleaner(this.classeCible.getC());
    }

    @Override
    public VueRelation getImage() {
        return new VueHeritage(this);
    }
}
