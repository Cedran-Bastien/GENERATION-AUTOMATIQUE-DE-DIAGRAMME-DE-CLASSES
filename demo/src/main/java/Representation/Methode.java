package Representation;

import java.util.List;

public class Methode extends Composante {


    public Methode() {
        super(n, a, m, t);
    }

    public VueInstance getModelisation() {
        //todo
        return null;
    }

    /**
     * Methode retournant le squelette de la methode
     *
     * @return
     */
    public String getSquelette() {
        String phrase = "";
        phrase+=this.acces+" "+this.type+" "+this.nom+"(";
        return null;
    }
}
