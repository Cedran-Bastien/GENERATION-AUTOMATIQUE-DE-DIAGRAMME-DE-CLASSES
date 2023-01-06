package Representation;

public class Methode extends Composante {
    Class[] parametres;

    /**
     * Constructeur construisant une methode sans parametres
     *
     * @param nom
     * @param retour
     */
    public Methode(String nom, Class retour) {
        super(nom, retour);
        this.parametres=null;
    }

    /**
     * Constructeur construisant une methode avec un ou plusieurs parametres
     *
     * @param nom
     * @param retour
     * @param p
     */
    public Methode(String nom, Class retour, Class[] p) {
        super(nom, retour);
        this.parametres = p;
    }

    /**
     * Methode retournant une description de la methode
     *
     * @return
     */
    public String toString() {
        String phrase = this.getAcces() + " " + this.nom + "(";
        if (this.parametres == null || this.parametres.length!=0 ) {
            for (int i = 0; i < this.parametres.length - 1; i++) {
                phrase += this.cleaner(this.parametres[i]) + ",";
            }
            phrase += this.cleaner(this.parametres[this.parametres.length-1]);
        }
        phrase += "):";
        phrase += this.cleaner(this.type);
        return phrase;
    }
    @Override
    public boolean equals(Object obj) {
     Methode methode=(Methode) obj;
        return super.equals(methode)&&this.equals(methode);
    }
}
