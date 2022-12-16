package Representation;

public class Attribut extends Composante {

    public Attribut(String n, String t) {
        super(n, t);
    }
    /**
     * Methode retournant une description de l'attribut
     * @return
     */
    public String toString() {
        String phrase=this.getAcces()+" "+this.nom+" "+this.type;
        return phrase;
    }
}
