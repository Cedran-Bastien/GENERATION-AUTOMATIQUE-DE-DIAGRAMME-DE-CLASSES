package Representation;

import Vue.VueInstance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Instance extends Globale {
    private VueInstance vue;
    private Class c;
    protected List<Methode> methodes;
    protected List<Attribut> attributs;
    /**
     * on ne traitera plus les importations en gardera juste en memoire
     * les differentes classe participantes.
     */
    protected ArrayList<String> imports;

    protected List<Relation> relations;

    protected String retour;
    protected int X;
    protected int Y;
    protected boolean afficherInstance;
    protected boolean afficherMethode;
    protected boolean afficherAttributs;

    public Instance(Class c1) throws ClassNotFoundException {
        this.imports = new ArrayList<>();
        this.nom = c1.getSimpleName();
        this.modifier = c1.getModifiers();
        this.c = c1;
        this.chargerAttribut();
        this.chargerMethodes();
        //Les relations seront ajouté par le modele
        this.relations = new ArrayList<Relation>();
        this.afficherInstance = true;
        this.afficherMethode = true;
        this.afficherAttributs = true;
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
        if (this.afficherAttributs) {
            resultat += "\nattributs:" + "\n";
            for (Attribut c : this.attributs) {
                resultat += c.toString() + "\n";
            }
        }
        resultat += "-------------\n";
        if (this.afficherMethode) {
            resultat += "methodes: \n";
            for (Methode m : this.methodes) {
                resultat += m.toString() + "\n";
            }
        }
        resultat += "--------------\n";
        for (Relation r : this.relations) {
            if (afficherRelation(r)) {
                resultat += r.toString() + "\n";
            }
        }
        return resultat;
    }

    /**
     * Methode verifiant si l'instance cible est afficher de la relation est afficher
     */
    public boolean afficherRelation(Relation r) {
        return r.getClasseCible().afficherInstance;
    }

    public VueInstance getImage() {
        vue = new VueInstance(this);
        return vue;
    }

    //Methode creant les attributs et les chargant dans la list
    public void chargerAttribut() throws ClassNotFoundException {
        this.attributs = new ArrayList<Attribut>(0);
        for (Field f : this.c.getDeclaredFields()) {
            Attribut attribut = new Attribut(f.getName(), f.getType());
            this.attributs.add(attribut);
            //On recupere le type de la liste de l'attribut ,on met à jour tout les retour.
            //On test si la classe de le contenant est une liste.
            if (f.getType().equals(Class.forName(List.class.getName())) || List.of(f.getType().getInterfaces()).contains(List.class)) {
                String r = f.getGenericType().getTypeName().replace(f.getType().getName(), f.getType().getSimpleName());
                r = r.replace(f.getType().getSimpleName() + "<", "");
                r = r.replaceFirst(">", "");
                attribut.setRetour(r);
            } else {
                attribut.setRetour(f.getGenericType().getTypeName());
            }
        }
    }

    /**
     * Methode chargeant les methodes et les ajoutants à la liste de methodes
     */
    public void chargerMethodes() {
        this.methodes = new ArrayList<Methode>(0);
        Methode m1 = null;
        for (Method m : this.c.getDeclaredMethods()) {
            if (m.getParameters() != null || m.getParameters().length > 0) {
                m1 = new Methode(m.getName(), m.getReturnType(), m.getParameterTypes());
            } else {
                m1 = new Methode(m.getName(), m.getGenericReturnType().getClass());
            }
            this.methodes.add(m1);

            //On test si la classe de le contenant est une liste.
            //On recupere le type de la liste de la methode ,on met à jour tout les retour.
            if (m.getReturnType().equals(List.class) || List.of(m.getReturnType().getInterfaces()).contains(List.class)) {
                m1.setRetour(m.getReturnType().getSimpleName() + m.getGenericReturnType().getTypeName().replace(m.getReturnType().getName(), ""));
            } else if (m.getGenericReturnType().getTypeName().contains("[]")) {
                m1.setRetour(m.getGenericReturnType().getTypeName().replace("[]", ""));
            } else {
                m1.setRetour(m.getReturnType().getName());
            }
            this.methodes.add(m1);
            // System.out.println(m1.getSquellette());
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
     *
     * @param x abscisse de la classe
     * @param y ordonnee de la classe
     */
    public void placerClasse(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * retourne la list de relation concernant cette classe
     *
     * @return la liste de relation
     */
    public List<Relation> getRelations() {
        return relations;

    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof Instance) {
            Instance instance = (Instance) obj;
            eq = instance.getNom().contains(this.nom) && instance.getAttributs().equals(this.getAttributs()) && this.getMethodes().equals(instance.getMethodes());
        }
        return eq;
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
        vue.actualiser();
    }

    public void setAfficherInstance(boolean afficherInstance) {
        this.afficherInstance = afficherInstance;
        vue.actualiser();
    }

    public void setAfficherMethode(boolean afficherMethode) {
        this.afficherMethode = afficherMethode;
        vue.actualiser();
    }

    public String getSquellette() throws ClassNotFoundException {
        String phrase = "";

        return phrase;
    }

    public VueInstance getVue() {
        return vue;
    }


    public void setVue(VueInstance vue) {
        this.vue = vue;
    }

    /**
     * Cette methode permet de récuperer les differents imports que l'instance
     * a besoin à priori .Ces informations sont definie à l'aide
     * des signatures des methodes et des attributs ,en effet
     * nous ne gererons pas l'interieur de la methode(en cas d'utilisation d'autre élément)
     * car ce n'est pas ce qui est demandé:
     * cette methode nous servira pour la generation du squelette.
     *
     * @throws ClassNotFoundException
     */
    public void chargerImport() throws ClassNotFoundException {
        this.imports = new ArrayList<>();
        //On charge les imports necessaire pour les attributs
        for (Attribut a : this.attributs) {
            if (a.getType() != null) {
                //Test pour le type de contenant (si liste par exemple)
                //les primitves ne sont pas a importer
                if (a.getType().equals(List.class) || List.of(a.getType().getInterfaces()).contains(List.class)) {
                    if (!this.imports.contains(a.getType().getName())) {
                        this.imports.add(a.getType().getName());
                    }
                }
            }
            //Test pour le contenu
            String r = a.getRetour();
            //On verifie que r est bien une clase
            r = this.testClass(r);
            if (r != null && !this.imports.contains(r)) {

                //Probleme de repetition des imports ,il a été préféré de prendre
                //une classe et den recuperer le nom.

                this.imports.add(Class.forName(r).getName());
                //Gestion des tableaux
            }
        }
        //Nous traitons desormais les retours des methodes
        for (Methode m : this.methodes) {
            String r = m.getRetour().replace(m.getType().getSimpleName(), "");
            r = this.testClass(r);
            if (r != null && !this.imports.contains(r)) {
                this.imports.add(Class.forName(r).getName());
            }
            //Maintenant nous traitons les parametres des methodes
            for (Class c2 : m.getParametres()) {
                //On ne tiendra pas compte du contenu des list ou des tableaux ici
                r = c2.getCanonicalName().replace("[]", "");
                if (!this.imports.contains(r) && !c2.isPrimitive()) {
                    this.imports.add(Class.forName(r).getName());
                }
            }
        }
        System.out.println(this.imports.size());
        for (String c1 : this.imports) {
            System.out.println("import " + c1 + ";");
        }
    }

    public String genererSquelette() {
        String phrase = "";
        for (String c1 : this.imports) {
            phrase = "-import " + c1 + ";\n";
        }
        return phrase;
    }

    private String testClass(String s) {
        String b = "";
        //extraction de la class dans une liste
        b = s.replaceFirst("<", "");
        b = b.replaceFirst(">", "");

        //extraction de la class contenu dans un tableau
        b = b.replace("[]", "");

        //Test de l'existance de la classe extraite
        try {
            Class c3 = Class.forName(b);
        } catch (ClassNotFoundException e) {
            b = null;
        }
        return b;
    }



    public Boolean getAfficherInstance() {
        return afficherInstance;
    }

    public Boolean getAfficherMethode() {
        return afficherMethode;
    }

    public Boolean getAfficherAttributs() {
        return afficherAttributs;
    }

}