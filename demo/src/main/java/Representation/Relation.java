package Representation;

import Vue.VueRelation;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public abstract class Relation extends Group {

    protected int xDebut;
    protected int yDebut;
    protected int xFin;
    protected int yFin;
    protected Instance classeCible;

    public Relation(Instance cible) {
        this.classeCible =cible;
    }

    public Relation(int xd, int yd, int xf, int yf){
        xDebut = xd;
        yDebut = yd;
        xFin = xf;
        yFin = yf;
    }

    public abstract String toString();

    public abstract VueRelation getImage();


    public Instance getClasseCible() {
        return classeCible;
    }

    public int getXDebut(){
        return xDebut;
    }

    public int getYDebut(){
        return yDebut;
    }

    public int getXFin(){
        return xFin;
    }

    public int getYFin(){
        return yFin;
    }

    /**
     * Methode servant à clarifier les noms des classes java.
     * @param c
     * @return
     */
    public String cleaner(Class c){
        String retour;
        if (c.getName().contains("java.")) {
            retour=c.getSimpleName();
        }else {
            retour= c.getName();
        }
        return retour;
    }

}
