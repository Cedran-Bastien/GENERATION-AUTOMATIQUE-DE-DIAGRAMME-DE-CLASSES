package Representation;

import java.util.List;
public class Classe extends Instance {
    public Classe(Class c) {
        super(c);
    }

    @Override
    public String toString() {
        return "C"+super.toString();
    }
}