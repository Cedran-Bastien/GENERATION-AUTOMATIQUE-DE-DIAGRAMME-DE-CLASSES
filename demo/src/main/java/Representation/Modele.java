package Representation;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

public class Modele {
    private File repertoire;

    private List <Instance>classeInit;


    /**
     * Constructeur
     * @param Source chemin du repertoire selectionné
     *
     *Le constructeur vérifie la nature de l'instance et l'ajoute dans
     *classeinit,les instances ne figurant pas dans le repertoire
     *mais qui sont utlisé sont ajouter dans classeCacher
     *classeRajouter sera initialisé à 0;
     */
    public Modele(String Source) throws ClassNotFoundException {
        File repertoire=new File(Source);
        File [] listfichier=repertoire.listFiles();
        this.classeInit=new ArrayList<>();
        //todo

    }

    /**
     * Methode privé creant les instances et les ajoutants à classeInit
     */
    private void creationInstance(String chemin) throws ClassNotFoundException {
        Class c=Class.forName(chemin);
        if(c.isInterface()){
            //todo
        }else{
            //todo
        }
    }

    /**
     * Methode permettant d'enregistrer les differentes relations
     */
    private void creationRelation(){
        //todo
    }

}
