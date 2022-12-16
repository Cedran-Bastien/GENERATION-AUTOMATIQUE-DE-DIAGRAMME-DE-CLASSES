package Representation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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

    public Instance(Class c) {
        this.nom = c.getName();
        this.modifier = c.getModifiers();
        Field[] fields = c.getDeclaredFields();
        for(int i = 0;fields.length > i;i++){
            attributs.add(new Attribut(fields[i].getName(),Modifier.toString(fields[i].getModifiers())));
        }
        Method[] meths = c.getDeclaredMethods();
        for(int i = 0;meths.length > i;i++){
            attributs.add(new Methode(meths[i].getName(),Modifier.toString(meths[i].getModifiers())));
        }
    }

    public List<Composante> getAttributs() {
        return attributs;
    }

    public List<Composante> getMethodes() {
        return methodes;
    }

    public void ajouterAttribut(Attribut a){
        attributs.add(a);
    }

    public void ajouterMethode(Methode m){
        methodes.add(m);
    }

    public String toString(){
        String resultat;
        resultat = "type: " + Modifier.toString(modifier) + "\nnom : " +  this.nom;
        return resultat;
    }
}
