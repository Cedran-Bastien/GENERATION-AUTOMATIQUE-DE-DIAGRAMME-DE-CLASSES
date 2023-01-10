package Representation;

import java.lang.reflect.Modifier;

public class Classe extends Instance {
    public Classe(Class c) {
        super(c);
    }

    @Override
    public String getType() {
        return "Classe";
    }

    @Override
    public String toString() {
        String phrase = "";
        if (this.afficherInstance) {
            phrase = Modifier.toString(this.getModifier()) + " Classe" + " " + this.nom + super.toString();
        }
        return phrase;
    }

    @Override
    public String getSquellette() {
        String phrase = Modifier.toString(this.modifier) + " class " + this.nom;
        if(this.getParent()!=null) {
            phrase += " extends " + this.getParent().getC().getSimpleName();
        }
            if (this.getC().getInterfaces().length > 0) {
                phrase += " implements ";
                for (int i = 0; i < this.getC().getInterfaces().length - 1; i++) {
                    phrase += this.getC().getInterfaces()[i].getSimpleName() + ",";
                }
                phrase += this.getC().getInterfaces()[this.getC().getInterfaces().length - 1].getSimpleName();
            }
        phrase += "{\n";
        for (Attribut a : this.attributs) {
            phrase += a.getSquelette() + "\n";
        }
        for (Methode m : this.methodes) {
            phrase += m.getSquellette() + "\n";
        }
        phrase += "}";
        return phrase;
    }


    /**
     * Methode retournant l'instance parent
     * @return
     */
    public Instance getParent(){
       Classe parent=null;
        for (Relation r:this.relations) {
            if(r instanceof Heritage){
                parent=(Classe)r.classeCible;
            }
        }
        if(parent==null && this.getC()!=null){
            parent=new Classe(this.getC().getSuperclass());
        }
        return parent;
    }
}