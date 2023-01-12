package Representation;


import Vue.VueInstance;
import Vue.VueRelation;
import javafx.collections.ListChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Modele implements Sujet {


    public static final String JPEG_FORMAT = "jpeg";
    public static final String PNG_FORMAT = "png";
    public static Instance courante;
    private File repertoire;
    private Pane pane;
    private List<Instance> classeInit;
    public List<Observer> observateursInstance = new ArrayList<Observer>(0);


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
        this.observateursInstance = new ArrayList<Observer>();
        this.creationInstance(source);
        this.creationRelation();
    }


    public Modele(String source, Pane p) throws ClassNotFoundException, IOException {
        this.pane = p;
        this.repertoire = new File(source);
        this.classeInit = new ArrayList<Instance>();
        this.observateursInstance = new ArrayList<Observer>();
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
                //(Ceci est verifié dans le loader)
            }
             List<Class>classes=new Loaders().loadFromFile(this.repertoire);
            for (Class c1:classes) {
                this.chargementInstance(c1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Methode permettant d'enregistrer les differentes relations
     */
    private void creationRelation() throws ClassNotFoundException {
        for (Instance i : this.classeInit) {
            //Heritage:
            Class h = i.getC().getSuperclass();
            if (h != null) {

                Classe heritage= (Classe) this.rechercherInstance(h.getName());
                if(this.classeInit.contains(heritage)) {
                    i.ajouterRelation(new Heritage(heritage));
                }
            }
            //Implementation
            Class[] interfaces = i.getC().getInterfaces();
            for (Class in : interfaces) {
                Interface anInterface= (Interface) this.rechercherInstance(in.getName());
                if (i instanceof Classe) {
                    i.ajouterRelation(new Implementation(anInterface));
                } else {
                    Heritage heri = new Heritage(anInterface);
                    if (!i.getRelations().contains(heri)) {
                        i.ajouterRelation(heri);
                    }
                }
            }
            //Association
            for (Attribut a : i.getAttributs()) {
                Instance ajoute = this.rechercherInstance(a.getInstance().getC().getName());
                for (Instance i2 : this.classeInit) {
                    if (a.getRetour().contains(i2.getNom())) {
                        String[] s = this.SymboleAsso(i, a);
                        Association r=new Association(ajoute, s[0], s[1], a.getNom());
                            i.ajouterRelation(r);
                    }
                }
            }
            System.out.println(i.getNom());
            for (Relation r1:
            i.getRelations()) {
                System.out.println(r1);
            }
            System.out.println(i.getRelations().size());
            //System.out.println(this.classeInit.get(3).getRelations().size());
        }
    }

    /**
     * Methode determinant les symboles a utilisé
     */
    public String[] SymboleAsso(Instance i, Attribut i2) throws ClassNotFoundException {
        String cible = i2.getRetour();
        String sy="";
if(cible.contains(List.class.getSimpleName())){
    sy="*";
}else {
    sy="1";
}
        return new String[]{"1",sy };

    }

    /**
     * Methode comptant le nombre diteration de l'instance en qualité d'attribut atomique
     *
     * @param j
     * @param i
     * @return
     */
    public int estpresent(Instance j, Instance i) {
        int trouve = 0;
        for (Attribut a : j.getAttributs()) {
            if (a.getType().equals(i.getC())) {
                trouve++;
            }
        }
        return trouve;
    }

    public void gestionTableau(Instance i, Instance j) {
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
    public Instance chargementInstance(Class c) throws ClassNotFoundException {
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
    public void genererGraphe() {

        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int widthScreen = (int) dimension.getWidth();
        int heightScreen = (int) dimension.getHeight();
        for (Instance i : this.classeInit) {
            int x = (int) ((Math.random()) * (widthScreen - 100));
            int y = (int) ((Math.random()) * (heightScreen - 200) + 60);

            i.placerClasse(x, y);
            VueInstance o = i.getImage();
            i.setVue(o);
            VueInstance v = (o);


            //initialisation des deplacement des vue
            v.setOnMouseDragged(e -> {
                this.setCourante(i);
                i.placerClasse((int) e.getSceneX(), (int) e.getSceneY());
                //this.actualiserRelation();
                this.notifierObserver();
            });

            i.getVue().widthProperty().addListener(e -> {
                for (Relation r : i.getRelations()){
                    double vd = i.getY() + i.getVue().getHeight();
                    //calcule des equation des diagonal de l'instance source
                    double[] equ1 = Modele.calculerEquation(i.getX(),i.getY(),i.getX()+i.getVue().getWidth(), vd);
                    double[] equ2 = Modele.calculerEquation(i.getX(), vd,i.getY(),i.getX()+i.getVue().getWidth());


                    Instance cible = r.getClasseCible();

                    //seulement quand les attribut de la vdue sont initialiser
                    VueInstance vue = cible.getVue();
                    //vue.widthProperty().addListener(en -> {
                    //calcule du millieu de la cible
                    VueInstance vueCible  = cible.getVue();
                    double xMillieu = cible.getX() + (vueCible.getWidth())/2;
                    double yMillieu = cible.getY() + (vueCible.getHeight())/2;

                    //calcule de y pour les deux droite
                    double y1 = xMillieu * equ1[0] + equ1[1];
                    double y2 = xMillieu * equ2[0] + equ2[1];

                    //mise a jpur des attribut de la relation de la relation
                    //en haut
                    if (yMillieu>y1 && xMillieu> y2){
                        r.setxDebut((int) (i.getX()+(i.getVue().getWidth())/2));
                        r.setyDebut( i.getY());
                        r.setxFin((int) (cible.getX()+(cible.getVue().getWidth())/2));
                        r.setyFin((int) (cible.getY()+ cible.getVue().getHeight()));
                        //a droite
                    }else if (yMillieu>y1 && xMillieu< y2){
                        r.setxDebut((int) (i.getX()+i.getVue().getWidth()));
                        r.setyDebut((int) (i.getY()+ (i.getVue().getHeight())/2));
                        r.setxFin(cible.getX());
                        r.setyFin((int) (cible.getY()+ (cible.getVue().getHeight())/2));
                        //en bas
                    }else if (yMillieu<y1 && xMillieu< y2){
                        r.setxDebut((int) (i.getX()+(i.getVue().getWidth())/2));
                        r.setyDebut((int) (i.getY()+ i.getVue().getHeight()));
                        r.setxFin((int) (cible.getX()+(cible.getVue().getWidth())/2));
                        r.setyFin(cible.getY());
                        //a gauche
                    }else if (yMillieu<y1 && xMillieu> y2){
                        r.setxDebut(i.getX());
                        r.setyDebut((int) (i.getY()+ (i.getVue().getHeight())/2));
                        r.setxFin((int) (cible.getX()+(cible.getVue().getWidth())));
                        r.setyFin((int) (cible.getY()+ (cible.getVue().getHeight())/2));
                    }
                }
                //});
            });
            this.ajouterObserver(o);
        }
        this.notifierObserver();
        this.genererRelation();
    }

    /**
     * creer les relations
     */
    private void genererRelation() {
        for (Instance i : this.classeInit) {
            for (Relation r : i.getRelations()){
                VueRelation vue =  r.getImage();
                this.ajouterObserver(vue);
            }
        }
    }

    /**
     * calcule l'equation de la droite a partir de deux point
     *
     * @param x1 absisse du premier point
     * @param y1 ordonnée du premier point
     * @param x2 absisse du deuxieme point
     * @param y2 ordonnée du deuxieme point
     * @return un tableau contenant les valeur de a et de b dans y = ax + b
     */
    public static double[] calculerEquation(double x1, double y1, double x2, double y2) {
        double a=0;
        if (x1 == x2) {
             a= 0;
        }
        a = (y2 - y1) / (x2 - x1);
        double b = y1 - a * x1;
        return new double[]{a, b};
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

    /**
     * ajoute un observer au modele et au Pane
     * @param o
     *      observer a ajouter
     */
    @Override
    public void ajouterObserver(Observer o) {
        this.observateursInstance.add(o);
        this.pane.getChildren().add((Node) (o));
    }

    /**
     * supprime un observer du modele et du Pane
     * @param o
     */
    @Override
    public void supprimerObserver(Observer o) {
        //TODO a faire
    }

    /**
     * actualise toute les vues du modeles
     */
    @Override
    public void notifierObserver() {
        System.out.println();
        for (Observer observer : this.observateursInstance) {
            observer.actualiser();
        }
    }


    public void setCourante(Instance courante) {
        this.courante = courante;
    }

    public void exporterSquellette() {
        //todo faire attention lors de l'ajout d"une classe dans quelle liste on l'ajoute
        String phrase = "";
        for (Instance i : this.classeInit) {
            if (i.afficherInstance) {
                phrase += Modifier.toString(i.getModifier()) + " class " + i.getNom() + "{\n";
                for (Attribut a : i.getAttributs()) {
                    phrase += Modifier.toString(a.getModifier()) + " " + a.getRetour() + " " + a.getNom() + ";\n";
                }
                for (Methode m : i.getMethodes()) {

                    phrase += Modifier.toString(Modifier.methodModifiers()) + " " + m.getRetour();
                }
            }
        }
    }

    public Instance getCourante() {
        return courante;
    }

    public Pane getPane() {
        return pane;
    }

    public void enregistrementDiagramme(String format) throws IOException {


        //Set extension filter
        FileChooser fileChooser = new FileChooser();;
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(format +" files (*."+format+")", "*."+format));
        //Prompt user to select a file
        File file;
        file = fileChooser.showSaveDialog(null);

        if (file!=null){
            WritableImage writableImage = this.pane.snapshot(new SnapshotParameters(),null);;
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
        }
    }
    public Instance rechercherInstance(String nom){
        Instance instance=null;
        for (Instance i:this.classeInit) {
            if(i.getC().getName().equals(nom)){
                instance=i;
            }
        }
        return instance;
    }
}
