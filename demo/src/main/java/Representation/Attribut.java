package Representation;

import java.lang.reflect.Modifier;

public class Attribut extends Composante {

    public Attribut(String n, Class a) {
        super(n, a);
        this.retour="";
    }

    /**
     * Methode retournant une description de l'attribut
     *
     * @return
     */
    public String toString() {
        String phrase;
        if (retour == "") {
            phrase = this.getAcces() + " " + this.nom + ":" + this.cleaner(this.type);
        } else {
            phrase = this.getAcces() + " " + this.nom + ":" + this.retour;
        }
        return phrase;
    }

    @Override
    public boolean equals(Object obj) {
        Attribut attribut = (Attribut) obj;
        return super.equals(obj) && this.retour.equals(attribut.getRetour());
    }

    /**
     * Methode convertissant un attribut en instance atomique(une seule instance)
     *
     * @return
     */
    public Instance getInstance() {
        Instance i = null;
        Class c = this.getType();
        if (this.getType().isInterface()) {
            i = new Interface(c);
        } else {
            i = new Classe(c);
        }
        i.setRetour(c.getCanonicalName());
        return i;
    }
    public String getSquelette(){
        String phrase="";
        phrase+= Modifier.toString(this.getModifier())+" "+this.getType().getSimpleName()+" "+this.nom+";";
        return phrase;
    }
}
