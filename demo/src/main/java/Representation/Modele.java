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
        this.vue = new ArrayList<Observer>();
        this.creationInstance(source);
        this.creationRelation();
        this.genererGraphe();
    }


    public Modele(String source, Pane p) throws ClassNotFoundException, IOException {
        this.pane = p;
        this.repertoire = new File(source);
        this.classeInit = new ArrayList<Instance>();
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
    private void creationRelation() {
        for (Instance i : this.classeInit) {
            //Heritage:
            Class h = i.getC().getSuperclass();
            if(h!=null) {
                i.ajouterRelation(new Heritage(i, new Classe(h)));
            }
            //Implementation
            Class[] interfaces = i.getC().getInterfaces();
            for (Class in : interfaces) {
                Interface inter = new Interface(in);
                i.ajouterRelation(new Implementation(i, inter));
            }
            //Association
            for (Attribut a : i.getAttributs()) {
                if (this.classeInit.contains(new Classe(a.getType())) || this.classeInit.contains(new Interface(a.getType()))) {
                  //  i.ajouterRelation(new Association(i,"1", , this.chargementInstance(a.getType())));
                }
            }
        }
    }

    /**
     * Methode determinant les symboles a utilisé
     */
    public void SymboleAsso(Instance i, Instance i2) {
        int j = 0;
        String nbcible;
        for (Attribut a : i.getAttributs()) {
            if (a.getType().equals(i2.getC())) {
                j++;
            }
            //this.renvoyerAssociation(a,i);
        }

    }

    /**
     * Methode comptant le nombre diteration de l'instance en qualité d'attribut atomique
     * @param j
     * @param i
     * @return
     */
    public int estpresent(Instance j,Instance i){
        int trouve=0;
        for (Attribut a:j.getAttributs()) {
            if(a.getType().equals(i.getC())){
                trouve++;
            }
        }
        return trouve;
    }
    public void gestionTableau(Instance i,Instance j){
       // System.out.println(i.getC().get);
    }

    /**
     * ajoute une instance a l'attibut classeInit
     *
     * @param i l'instance a ajouté
     */
    public void ajouterInstance(Instance i) {
        this.classeInit.add(i);
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
    public String toString() {
        String phrase = "";
        for (Instance i : this.classeInit) {
            phrase += i.toString() + "\n";
        }
        return phrase;
    }

    public List<Instance> getClasseInit() {
        return classeInit;
    }

    @Override
    public void ajouterObserver(Observer o) {

    }

    @Override
    public void supprimerObserver(Observer o) {

    }

    @Override
    public void notifierObserver() {

    }
}
