package Representation;

import Vue.VueInstance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Instance extends Globale {
    private Class c;
    private int X;
    private int Y;
    public List<Methode> methodes;
    protected List<Attribut> attributs;
    private VueInstance vueInstance;
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les differentes classe participantes.
     */
    protected List<Class<?>> imports;

    protected List<Relation> relations;

    public Instance(Class c1) {
        this.nom = c1.getName();
        this.modifier = c1.getModifiers();
        this.c = c1;
        this.chargerAttribut();
        this.chargerMethodes();
        this.relations = new ArrayList<Relation>();
    }

    public List<Attribut> getAttributs() {
        return attributs;
    }

    public List<Methode> getMethodes() {
        return methodes;
    }

    public abstract String getType();

    public void ajouterAttribut(Attribut a) {
        attributs.add(a);
    }

    public void ajouterMethode(Methode m) {
        methodes.add(m);
    }

    @Override

    public String toString() {
        String resultat = "\nattributs:" + "\n";
        for (Attribut c : this.attributs) {
            resultat += c.toString() + "\n";
        }
        resultat += "-------------\n";
        resultat += "methodes: \n";
        for (Methode m : this.methodes) {
            resultat += m.toString() + "\n";
        }
        resultat += "--------------";
        for (Relation r:this.relations) {
            r.toString();
        }
        return resultat;
    }

    /**
     * Methode renvoyant le nom sans les packages
     *
     * @return
     */
    public String getSimpleNom() {
        String[] nom = this.nom.split(".");
        return nom[nom.length - 1];
    }

    public VueInstance getImage(){
        VueInstance vue =  new VueInstance(this);
        this.vueInstance = vue;
        return vue;
    }

    //Methode creant les attributs et les chargant dans la list
    public void chargerAttribut() {
        this.attributs = new ArrayList<Attribut>(0);
        for (Field f : this.c.getDeclaredFields()) {
            this.attributs.add(new Attribut(f.getName(), f.getType()));
        }
    }

    /**
     * Methode chargeant les methodes et les ajoutants à la liste de methodes
     */
    public void chargerMethodes() {
        this.methodes = new ArrayList<Methode>(0);
        for (Method m : this.c.getDeclaredMethods()) {
            if (m.getParameters() != null || m.getParameters().length>0) {
                this.methodes.add(new Methode(m.getName(),m.getReturnType(), m.getParameterTypes()));
            } else {
                this.methodes.add(new Methode(m.getName(), m.getGenericReturnType().getClass()));
            }
        }
    }

    /**
     * Methode appeler par le modele pour rajouter les relations
     *
     * @param r
     */
    public void ajouterRelation(Relation r) {
        this.relations.add(r);
    }

    public Class getC() {
        return c;
    }

    /**
     * met a jour la position d'une classe
     * @param x
     *      abscisse de la classe
     * @param y
     *      ordonnee de la classe
     */
    public void placerClasse(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * retourne la list de relation concernant cette classe
     * @return
     *      la liste de relation
     */
    public List<Relation> getRelations() {
        return relations;
    }
}