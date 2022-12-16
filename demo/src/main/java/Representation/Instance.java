package Representation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

public abstract class Instance extends Globale {

    protected List<Composante> methodes;
    protected List<Composante> attributs;
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les diffenrentes classe participantes.
     */
    protected List<Class<?>> imports;

    public Instance(Class c) throws Exception {
        super(c.getName(),c.getModifiers());
        Field[] fields = c.getDeclaredFields();
        for(int i = 0;fields.length > i;i++){
            attributs.add(new Attribut(fields[i].getName(),fields[i].getModifiers()));
        }
        Method[] meths = c.getDeclaredMethods();
        for(int i = 0;meths.length > i;i++){
            attributs.add(new Methode(meths[i].getName(),meths[i].getModifiers()));
        }
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
