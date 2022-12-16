package Representation;

import java.lang.reflect.Modifier;
import java.util.List;

public class Interface extends Instance {

    public Interface(Class c) {
        super(c);
    }

    @Override
    public String toString() {
        return "I "+ Modifier.toString(this.modifier) + "\nnom : " +  this.nom +" "+super.toString();
    }

}
