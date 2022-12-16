package Representation;

import java.util.List;

public abstract class Composante extends Globale {
    protected String type;
    public Composante(String n, String a, List<String> m,String t) {
        super(n, a, m);
        this.type=t;
    }

    public String getType() {
        return type;
    }

    /**
     * Methode permettant de generer un squelette
     * @return
     */
    public abstract String getSquelette();
}
