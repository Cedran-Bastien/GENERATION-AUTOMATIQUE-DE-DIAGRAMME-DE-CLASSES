package Representation;

import java.lang.reflect.Type;
import java.util.List;

public class Composante extends Globale{
    protected String type;
    public Composante(String n,String t){
        this.nom=n;
        this.type=t;
    }

    public String getType() {
        return type;
    }

}
