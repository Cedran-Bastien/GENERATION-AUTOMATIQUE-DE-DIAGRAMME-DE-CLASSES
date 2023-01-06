package Representation;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public abstract class VueRelation extends Observer {
    protected int xDebut;
    protected int xFin;
    protected int yDebut;
    protected int yFin;

    protected Line chemin;
    protected Line pointeA;
    protected Line pointeB;


}