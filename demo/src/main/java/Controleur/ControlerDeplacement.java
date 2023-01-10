package Controleur;

import Vue.VueInstance;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Node;
import javafx.scene.input.MouseDragEvent;

public class ControlerDeplacement implements EventHandler<MouseDragEvent> {

    @Override
    public void handle(MouseDragEvent mouseDragEvent) {
        ((VueInstance)(mouseDragEvent.getTarget())).setLayoutX(mouseDragEvent.getX());
        ((VueInstance)(mouseDragEvent.getTarget())).setLayoutY(mouseDragEvent.getY());
    }
}
