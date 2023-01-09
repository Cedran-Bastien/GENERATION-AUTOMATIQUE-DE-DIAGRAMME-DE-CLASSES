package Representation;

import java.util.ArrayList;
import java.util.List;

public interface Sujet {

    public void ajouterObserver(Observer o);
    public void supprimerObserver(Observer o);
    public void notifierObserver();
}
