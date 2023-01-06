package Representation;

public class Attribut extends Composante {

    public Attribut(String n, Class a) {
        super(n, a);
    }
    /**
     * Methode retournant une description de l'attribut
     * @return
     */
    public String toString() {
        String phrase=this.getAcces()+" "+this.nom+":"+this.cleaner(this.type);
        return phrase;
    }

    @Override
    public boolean equals(Object obj) {
        Attribut attribut=(Attribut) obj;
        return super.equals(obj)&&this.type.equals(attribut.getType());
    }
}
