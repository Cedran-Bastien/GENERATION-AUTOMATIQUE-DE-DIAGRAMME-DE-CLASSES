package Representation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Instance extends Globale {

    protected List<Composante>methodes;
    protected List<Composante>attributs;
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les diffenrentes classe participantes.
     */
    protected List<Class<?>> imports;

    public Instance(String chemin) throws ClassNotFoundException {
        super(chemin);
Class c=Class.forName(chemin);
        this.imports= List.of(c.getClasses());

        this.methodes= new ArrayList<>();
        for (Method m:
             c.getMethods()) {
            this.methodes.add(new Methode(m));
        }
    }

    public List<Composante> getAttributs() {
        return attributs;
    }

    public List<Class<?>> getImports() {
        return imports;
    }

    public List<Composante> getMethodes() {
        return methodes;
    }
    public abstract String toString();
}
