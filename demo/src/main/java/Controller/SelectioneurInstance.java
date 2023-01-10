package Controller;

import Representation.Modele;
import Representation.Observer;
import Vue.VueInstance;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Classe permettant de selectionner une instance graphiquement
 */
public class SelectioneurInstance implements EventHandler {
    Modele modele;

    public SelectioneurInstance(Modele m) {
        this.modele = m;
        this.Attribution();
    }

    @Override
    public void handle(Event event) {
        VueInstance source = (VueInstance) event.getSource();
        this.modele.setCourante(source.getInstance());
        this.modele.notifierObserver();
    }


    public void setModele(Modele modele) {
        this.modele = modele;
    }

    /**
     * Methode permettant d'attribuer le selectioneur d'instance à tous les observateurs de type
     * vueInstance
     */
    public void Attribution() {
        for (Observer observer : this.modele.observateursInstance) {
            if (observer instanceof VueInstance) {
                ((VueInstance) observer).setOnMouseClicked(this);
            }
        }
    }
}
