package Representation;

import java.lang.reflect.Modifier;
import java.util.List;

public abstract class Globale {
    protected String nom;
    protected String acces;
    protected int modifier;
    protected boolean visible;

    public Globale(String chemin) throws ClassNotFoundException {
        this.modifier= List.of(Modifier.toString(Class.forName(chemin).getModifiers()).split(" "));
        this.nom=chemin;
        this.visible=true;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getNom() {
        return nom;
    }

    public int getModifier() {
        return modifier;
    }

    public String getAcces() {
        return acces;
    }
}
