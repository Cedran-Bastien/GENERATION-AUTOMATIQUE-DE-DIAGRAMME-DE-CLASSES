package Representation;

import java.lang.reflect.Modifier;
import java.util.List;
public class Classe extends Instance {
    public Classe(Class c) {
        super(c);
    }

    @Override
    public String toString() {
        return "C "+ Modifier.toString(this.modifier) + "\nnom : " +  this.nom +" "+super.toString();
    }
}