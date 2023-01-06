package Representation;

public interface Sujet {

    public void ajouterObserver(Observer o);
    public void supprimerObserver(Observer o);
    public void notifierObserver();
}
