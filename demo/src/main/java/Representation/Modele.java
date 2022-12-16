package Representation;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class Modele {
    private File repertoire;
    private List<Instance> classeInit;
    private List<Relation> relation;


    /**
     * Constructeur
     * @param source chemin du repertoire selectionné
     *
     *Le constructeur vérifie la nature de l'instance et l'ajoute dans
     *classeinit,les instances ne figurant pas dans le repertoire
     *mais qui sont utlisé sont ajouter dans classeCacher
     *classeRajouter sera initialisé à 0;
     */
    public Modele(String source) throws ClassNotFoundException {
        this.classeInit=new ArrayList<Instance>();
        this.relation = new ArrayList<Relation>();
        this.creationInstance(source);
        this.creationRelation();
    }

    /**
     * Methode privé creant les instances et les ajoutants à classeInit
     */
    private void creationInstance(String chemin) throws ClassNotFoundException {
        File f = new File(chemin);
        File[] list = f.listFiles();

        //parcour des fichier du repertoire
        for (File fich : list){
            String nomAct = fich.getName();
            if (fich.isDirectory()){
                this.creationInstance(nomAct);
            }
            else{
                Class c = Class.forName(nomAct);
                Instance i =null;
                if (c.isInterface()){
                    i = new Interface(c);
                }else {
                    i = new Classe(c);
                }
                this.ajouterInstance(i);

                //gestion des relation propre a la classe courante
                //pour l'heritage
                Class sup = c.getSuperclass();
                this.ajouterRelation(new Heritage(c.getName(),sup.getName()));

                //pour l'implementation
                Class[] imp = c.getInterfaces();
                for (Class ced : imp){
                    this.ajouterRelation(new Implementation(c.getName(),ced.getName()));
                }

            }
        }
    }

    /**
     * Methode permettant d'enregistrer les differentes relations
     */
    private void creationRelation(){
        for (Instance classe : this.classeInit){
            List<Composante> comp =  classe.getAttributs();
            for (Composante composante : comp){
                String nom = composante.getNom();
                for (Instance classe1 : this.classeInit){
                    String nomClasse = classe1.getNom();
                    if (nomClasse==nom){
                        String typeAtt= composante.getType();
                        if (typeAtt.contains("List") || typeAtt.contains("[]")){
                            Relation r = new Association(classe.getNom(),typeAtt,"1","*",composante.getNom());
                            this.ajouterRelation(r);
                        }else{
                            Relation r = new Association(classe.getNom(),typeAtt,"1","1",composante.getNom());
                            this.ajouterRelation(r);
                        }
                    }
                }
            }
        }
    }

    /**
     * ajoute une instance a l'attibut classeInit
     * @param i
     *      l'instance a ajouté
     */
    public void ajouterInstance(Instance i){
        this.classeInit.add(i);
    }

    public void ajouterRelation(Relation r){
        this.relation.add(r);
    }

    public List<Relation> getRelationSource(String name) {
        List res = new ArrayList<Relation>();
        for (Relation r : this.relation){
            if (r.classeSrc==name){
                res.add(r);
            }
        }
        return res;
    }

    public String toString(){
        String res ="";
        for (Instance i : this.classeInit){
            res+=i.toString()+"\n";
            for (Relation r : this.getRelationSource(i.getNom())){
                res+=r.toString();
            }
        }
        return res;
    }

}
