package Representation;

import java.lang.reflect.Modifier;
import java.util.List;

public abstract class Globale {
    protected String nom;
    protected String acces;
    protected int modifier;
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
