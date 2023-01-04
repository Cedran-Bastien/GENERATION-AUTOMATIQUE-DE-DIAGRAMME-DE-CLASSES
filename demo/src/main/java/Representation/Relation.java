package Representation;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public abstract class Relation extends Group {

    protected int xDebut;
    protected int yDebut;
    protected int xFin;
    protected int yFin;
    protected Line chemin;
    protected Line pointeA;
    protected Line pointeB;
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

    public abstract void update();
    public abstract String toString();

    public String getClasseSrc() {
        return classeSrc;
    }

    public String getClasseCible() {
        return classeCible;
    }
}
