package Representation;

import Vue.VueInstance;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Modele implements Sujet{
    private File repertoire;
    private Pane pane;
    private List<Instance> classeInit;
    private List<Relation> relation;
    private List<Observer> vue;


    /**
     * Constructeur
     *
     * @param source chemin du repertoire selectionné
     *               <p>
     *               Le constructeur vérifie la nature de l'instance et l'ajoute dans
     *               classeinit,les instances ne figurant pas dans le repertoire
     *               mais qui sont utlisé sont ajouter dans classeCacher
     *               classeRajouter sera initialisé à 0;
     */
    public Modele(String source) throws ClassNotFoundException, IOException {
        this.repertoire = new File(source);
        this.classeInit = new ArrayList<Instance>();
        this.relation = new ArrayList<Relation>();
        this.vue = new ArrayList<Observer>();
        this.creationInstance(source);
        this.creationRelation();
        this.genererGraphe();
    }


    public Modele(String source, Pane p) throws ClassNotFoundException, IOException {
        this.pane = p;
        this.repertoire = new File(source);
        this.classeInit = new ArrayList<Instance>();
        this.relation = new ArrayList<Relation>();
        this.vue = new ArrayList<Observer>();
        this.creationInstance(source);
        this.creationRelation();

    }

    /**
     * Methode privé creant les instances et les ajoutants à classeInit
     */
    private void creationInstance(String chemin) throws ClassNotFoundException, IOException {
        File f = new File(chemin);
        File[] list = f.listFiles();
        Class c = null;
        try {
            //On verifie si c'est un dossier avec des fichiers dedant
            if (list != null) {
                //parcours des fichier du repertoire
                for (File fils : list) {
                    //Si cest un dossier on appelle la methode sur le chemin absolue du fils
                    this.creationInstance(fils.getAbsolutePath());
                }
                //Quand cest un fichier on verifie que cest bien un .class et on appelle la fonction chargementInstance
            } else if (f.getName().endsWith(".class")) {
                this.chargementInstance(new Loaders().loadFromFile(f));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


        /**
         * Methode permettant d'enregistrer les differentes relations
         */
        private void creationRelation () {
//            for (Instance classe : this.classeInit) {
//                List<Composante> comp = classe.getAttributs();
//                for (Composante composante : comp) {
//                    String nom = composante.getType();
//                    for (Instance classe1 : this.classeInit) {
//                        String nomClasse = classe1.getNom();
//                        System.out.println("debug:"+nom+" p n// "+nomClasse);
//                        if (nomClasse == nom) {
//                            String typeAtt = composante.getType();
//                            System.out.println("debug:"+typeAtt);
//                            if (typeAtt.contains("List") || typeAtt.contains("[]")) {
//                                Relation r = new Association(classe.getNom(), typeAtt, "1", "*", composante.getNom());
//                                this.ajouterRelation(r);
//                            } else {
//                                Relation r = new Association(classe.getNom(), typeAtt, "1", "1", composante.getNom());
//                                this.ajouterRelation(r);
//                            }
//                        }
//                    }
//                }
//            }
        }

    /**
     * ajoute une instance a l'attibut classeInit
     *
     * @param i l'instance a ajouté
     */
    public void ajouterInstance(Instance i) {
        this.classeInit.add(i);
    }

        public void ajouterRelation (Relation r){
            this.relation.add(r);
        }

        public List<Relation> getRelationSource (String name){
            List res = new ArrayList<Relation>();
            for (Relation r : this.relation) {
//                if (r.classeSrc == name) {
//                    res.add(r);
//                }
            }
            return res;
        }

        public String toString () {
            String res = "";
            for (Instance i : this.classeInit) {
                res += i.toString() + "\n";
                for (Relation r : this.getRelationSource(i.getNom())) {
                    res += r.toString();
                }
            }
            return res;
        }

    /**
     * Methode permettant de creer une classe ou une interface en fonction de la class
     *
     * @param c
     */
    public Instance chargementInstance(Class c) {
        Instance i = null;
        if (c.isInterface()) {
            i = new Interface(c);
        } else {
            i = new Classe(c);
        }
        if (!this.classeInit.contains(i)) {
            this.ajouterInstance(i);
        }
        return i;
    }

    /**
     * met a jour le modele (place les classes) et creer l'affichage de ces classes
     */
    public void genererGraphe(){
        int maxy = 0;
        int x = 0;
        int y = 0;
        for (Instance i : this.classeInit){
            i.placerClasse(x,y);
            Observer o = i.getImage();
            o.actualiser();
            this.ajouterObserver(o);

            VueInstance vbox = (VueInstance) (o);
            vbox.widthProperty().addListener(e-> System.out.println(vbox.getInstance().getNom() + "  "+ vbox.getWidth()));
            int width = (int)(vbox.getWidth());
            x+= width + 50;
            int height = (int)(vbox.getHeight());
            if (maxy<height){
                maxy = height;
            }
            Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
            int widthScreen  = (int)dimension.getWidth();
            if (x+width>widthScreen){
                y += y+maxy+50;
                maxy = 0;
                x = 0;
            }
            //this.genererRelation();
        }
    }

    /**
     * met a jour les relation
     */
    private void genererRelation(){
        for (Instance i : this.classeInit){
        }
    }

    /**
     * calcule l'equation de la droite a partir de deux point
     * @param x1
     *      absisse du premier point
     * @param y1
     *      ordonnée du premier point
     * @param x2
     *      absisse du deuxieme point
     * @param y2
     *      ordonnée du deuxieme point
     * @return
     *      un tableau contenant les valeur de a et de b dans y = ax + b
     */
    public static double[] calculerEquation(int x1,int y1, int x2, int y2) {
        if (x1 == x2) return null;
        double a = (y2-y1) / (x2-x1);
        double b = y1 - a * x1;
        return new double[] { a, b };
    }

    @Override
    public void ajouterObserver(Observer o) {
        this.vue.add(o);
        this.pane.getChildren().add((Node)(o));
    }

    @Override
    public void supprimerObserver(Observer o) {
        //TODO a faire
    }

    @Override
    public void notifierObserver() {
        for (Observer observer : this.vue){
            observer.actualiser();
        }
    }
}
