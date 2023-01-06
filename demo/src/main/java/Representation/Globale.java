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
    /**
     * Methode clarifiant les nom de classe
     */
    public String cleaner(Class c){
        String retour;
        if (c.getName().contains("java.")) {
            retour=c.getSimpleName();
        }else {
            retour= c.getName();
        }
        return retour;
    }

    @Override
    public boolean equals(Object obj) {
        Globale globale=(Globale) obj;
        return this.nom==globale.nom&&this.modifier==globale.modifier;
    }
}
