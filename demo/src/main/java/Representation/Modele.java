package Representation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Modele {
    private File repertoire;
    private List<Instance> classeInit;
    private List<Relation> relation;
    private int[] j=new int[3];


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
        this.classeInit = new ArrayList<Instance>();
        this.relation = new ArrayList<Relation>();
        this.creationInstance(source);
        this.creationAssociation();
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
        private void creationAssociation() {
            //On parcours les Instances presentent dans le modele
                //pour chaque instances on fait:
                //On recupere ses attributs
                    //pour chaque attribut on fait:
                        //on regarde si c'est une liste ou un tableau
                            // si oui on recupere la classe des elements composant le tableau
                            //sinon on recupere la classe de l'attribut
                        //on regarde si il ya une classe correspondante dans le modele
                            //Si oui on creer une relation d'association et on lajoute au Modele
            for (Instance classe : this.classeInit) {
               List<Attribut> attributs=classe.getAttributs();
                for (Composante attribut:attributs) {
                    String classeAttribut=attribut.getType();
                    if (classeAttribut.contains("List")||classeAttribut.contains("[]")){
                        System.out.println("yes "+classeAttribut+" "+classe.nom);
                    }
                }
        }
}
        /**
         * ajoute une instance a l'attibut classeInit
         *
         * @param i l'instance a ajouté
         */
        public void ajouterInstance (Instance i){
            this.classeInit.add(i);
        }

        public void ajouterRelation (Relation r){
            this.relation.add(r);
        }

        public List<Relation> getRelationSource (String name){
            List res = new ArrayList<Relation>();
            for (Relation r : this.relation) {
                if (r.classeSrc == name) {
                    res.add(r);
                }
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
         * Methode permettant d'ajouter differentes relations dans le modele
         */
        public void chargementInstance(Class c){
            Instance i = null;
            if (c.isInterface()) {
                i = new Interface(c);
            } else {
                i = new Classe(c);
            }
            this.ajouterInstance(i);

            //gestion des relation propre a la classe courante
            //pour l'heritage
            Class sup = c.getSuperclass();
            if (sup != null) {
                this.ajouterRelation(new Heritage(c.getName(), sup.getName()));
            }
            //pour l'implementation
            Class[] imp = c.getInterfaces();
            for (Class ced : imp) {
                this.ajouterRelation(new Implementation(c.getName(), ced.getName()));
            }
            //pour l'association
            Field[] asso=c.getDeclaredFields();
            for (Field f: asso) {
                this.creationAssociation();
            }
        }
    }
