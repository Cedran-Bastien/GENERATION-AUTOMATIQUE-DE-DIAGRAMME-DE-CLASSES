package Representation;

import java.lang.reflect.Type;
import java.util.List;

public class Composante extends Globale{
    protected Class type;
    public Composante(String n,Class c){
        this.nom=n;
        this.type=c;
    }


    public Class getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
