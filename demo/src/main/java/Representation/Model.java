package Representation;

import java.io.File;
import java.util.List;

public class Model {
    private File repertoire;

    private List <Instance>classeInit;
    private List <Instance>classeRajouter;
    private List <Instance>classeCacher;

    /**
     * Constructeur
     * @param Source chemin du repertoire selectionné
     *
     *Le constructeur vérifie la nature de l'instance et l'ajoute dans
     *classeinit,les instances ne figurant pas dans le repertoire
     *mais qui sont utlisé sont ajouter dans classeCacher
     *classeRajouter sera initialisé à 0;
     */
    public Model(String Source) {
        //todo
    }

    /**
     * Methode ...
     */
    public void ajouterFormulaireMethode() {
        //todo
    }

    /**
     * Methode ...
     */
    public void ajouterFormulaireAttribut() {
        //todo
    }

    /**
     * Methode permetant d'afficher une classe au modele dans classeAjouter
     */
    public void ajouterClasse(){
        //todo
    }
    public Instance getParent() throws Exception {
        //todo
        throw new Exception("todo");
    }

}
