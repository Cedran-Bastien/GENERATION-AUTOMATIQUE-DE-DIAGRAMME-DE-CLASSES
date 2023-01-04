package Representation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Instance extends Globale {

    public List<Methode> methodes = new ArrayList<Methode>();
    protected List<Attribut> attributs = new ArrayList<>();
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les differentes classe participantes.
     */
    protected List<Class<?>> imports;

    public Instance(Class c) {
        this.nom = c.getName();
        this.modifier = c.getModifiers();
        Field[] fields = c.getDeclaredFields();
        for(int i = 0;fields.length > i;i++){
            attributs.add(new Attribut(fields[i].getName(),fields[i].getType().getName()));
        }
        Method[] meths = c.getDeclaredMethods();
        for(int i = 0;meths.length > i;i++){
            methodes.add(new Methode(meths[i].getName(),meths[i].getReturnType().getName()));
        }
    }

    public List<Attribut> getAttributs() {
        return attributs;
    }

    public List<Methode> getMethodes() {
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
        String resultat = "\nattributs:"+"\n";
        for(Attribut c : this.attributs){
            resultat +=c.getAcces()+" "+c.getType() + "\n";
        }
        resultat+="-------------\n";
        resultat += "methodes: \n";
        for(Methode c : this.methodes){
            resultat +=c.toString() + "\n";
        }
        resultat+="--------------";
        return resultat;
    }

    /**
     * Methode renvoyant le nom sans les packages
     * @return
     */
    public String getSimpleNom(){
        String[] nom=this.nom.split(".");
        return nom[nom.length-1];
    }
}
