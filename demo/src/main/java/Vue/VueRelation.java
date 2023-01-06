package Vue;

import Representation.Observer;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public abstract class VueRelation extends Pane implements Observer {
    protected int xDebut;
    protected int xFin;
    protected int yDebut;
    protected int yFin;

    protected Line chemin;
    protected Line pointeA;
    protected Line pointeB;


}
