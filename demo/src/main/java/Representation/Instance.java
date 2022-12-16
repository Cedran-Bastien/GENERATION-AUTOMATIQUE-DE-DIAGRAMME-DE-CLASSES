package Representation;

import java.util.List;
import java.util.Objects;

public abstract class Instance extends Globale {

    //  protected List<Composante> methodes;
    //protected List<Composante> attributs;
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les diffenrentes classe participantes.
     */
    protected List<Class<?>> imports;

    public Instance(String chemin) throws Exception {
        super(chemin);
        //todo
        throw new Exception("todo");
    }

    public List<Objects> getAttributs() {
    //todo
        return null;
    }

    public List<Objects> getImports() {
        //todo
        return null;
    }

    public List<Objects> getMethodes() {
        /// TODO
        return null;
    }

    public abstract String toString();
}
