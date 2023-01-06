package Representation;

import Vue.VueRelation;
import javafx.scene.Group;

public abstract class Relation extends Group {

    protected int xDebut;
    protected int yDebut;
    protected int xFin;
    protected int yFin;
    protected String classeSrc;
    protected String classeCible;

    public Relation(String src, String cible) {
        this.classeSrc = src;
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

    public String getClasseSrc() {
        return classeSrc;
    }

    public String getClasseCible() {
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
}
