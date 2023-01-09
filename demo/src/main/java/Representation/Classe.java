package Representation;

import java.lang.reflect.Modifier;
import java.util.List;
public class Classe extends Instance {
    public Classe(Class c) {
        super(c);
    }

    @Override
    public String getType() {
        return "Classe";
    }

    @Override
    public String toString() {
        String phrase="";
        if(this.afficherInstance) {
            phrase = Modifier.toString(this.getModifier()) + " Classe" + " " + this.nom + super.toString();
        }
        return phrase;
    }
}