package Representation;

public class Methode extends Composante {// extends Composante {

    public Methode(String nom, String type) {
        super(nom, type);
    }

    /**
     * Methode retournant une description de la methode
     * @return
     */
    public String toString() {
        String phrase=this.getAcces()+" "+this.nom+"():"+this.type;
        return phrase;
    }
}
