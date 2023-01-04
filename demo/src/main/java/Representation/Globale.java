package Representation;

import java.lang.reflect.Modifier;
import java.util.List;

public abstract class Globale {
    protected String nom;
    protected int modifier;

    public String getNom() {
        return nom;
    }

    public int getModifier() {
        return modifier;
    }

    public String getAcces() {
        if(Modifier.isPrivate(this.modifier)){
            return "private";
        } else if (Modifier.isPublic(this.modifier)) {
            return "protected";
        } else {
            return "public";
        }
    }
}
