package Representation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Instance extends Globale {

    protected List<Composante> methodes = new ArrayList<Composante>();
    protected List<Composante> attributs = new ArrayList<Composante>();
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
            attributs.add(new Attribut(fields[i].getType().getName(),Modifier.toString(fields[i].getModifiers())));
        }
        Method[] meths = c.getDeclaredMethods();
        for(int i = 0;meths.length > i;i++){
            methodes.add(new Methode(meths[i].getName(),meths[i].getReturnType().getName()));
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
    @Override

    public String toString(){
        String resultat="";
        resultat = "\n"+"attributs:"+"\n";
        for(Composante c : this.attributs){
            resultat +=c.toString() + "\n";
        }
        resultat+="-------------\n";
        resultat += "methodes: \n";
        for(int i = 0;i < methodes.size();i++){
            resultat = resultat + methodes.get(i).toString() + "\n";
        }
        resultat+="--------------";
        return resultat;
    }
}
