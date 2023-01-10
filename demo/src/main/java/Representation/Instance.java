package Representation;

import Vue.VueInstance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Instance extends Globale {
    private VueInstance vue;
    private Class c;
    public List<Methode> methodes;
    protected List<Attribut> attributs;
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les differentes classe participantes.
     */
    protected List<Class<?>> imports;

    protected List<Relation> relations;

    protected String retour;
    protected int X;
    protected int Y;
    protected boolean afficherInstance;
    protected boolean afficherMethode;
    protected boolean afficherAttributs;

    public Instance(Class c1) {
         this.nom = c1.getName();
        this.modifier = c1.getModifiers();
        this.c = c1;
        this.chargerAttribut();
        this.chargerMethodes();
        this.relations = new ArrayList<Relation>();
        this.afficherInstance=true;
        this.afficherMethode=true;
        this.afficherAttributs=true;
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
        String resultat = "";
        if(this.afficherAttributs){
            resultat+="\nattributs:" + "\n";
        for (Attribut c : this.attributs) {
                resultat += c.toString() + "\n";
        }
        }
        resultat += "-------------\n";
        if (this.afficherMethode){
        resultat += "methodes: \n";
        for (Methode m : this.methodes) {
            resultat += m.toString() + "\n";
        }
        }
        resultat += "--------------\n";
        for (Relation r:this.relations) {
            if(afficherRelation(r)) {
                resultat += r.toString() + "\n";
            }
        }
        return resultat;
    }

    /**
     * Methode verifiant si l'instance cible est afficher de la relation est afficher
     */
    public boolean afficherRelation(Relation r){
        return r.getClasseCible().afficherInstance;
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
        vue = new VueInstance(this);
        return vue;
    }

    //Methode creant les attributs et les chargant dans la list
    public void chargerAttribut() {
        this.attributs = new ArrayList<Attribut>(0);
        for (Field f : this.c.getDeclaredFields()) {
            Attribut attribut=new Attribut(f.getName(), f.getType());
            this.attributs.add(attribut);
            attribut.setRetour(f.getGenericType().getTypeName());
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

    @Override
    public boolean equals(Object obj) {
        Instance instance=(Instance) obj;
        return instance.getNom().contains(this.nom)&&instance.getAttributs().equals(this.getAttributs())&&this.getMethodes().equals(instance.getMethodes());
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }

    public String getRetour() {
        return retour;
    }


    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setAfficherAttributs(boolean afficherAttributs) {
        this.afficherAttributs = afficherAttributs;
    }

    public void setAfficherInstance(boolean afficherInstance) {
        this.afficherInstance = afficherInstance;
    }

    public void setAfficherMethode(boolean afficherMethode) {
        this.afficherMethode = afficherMethode;
    }
}