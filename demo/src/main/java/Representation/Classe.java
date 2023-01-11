package Representation;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * Methode renvoyant les differentes interfaces implementée
     * (Methode utilié pour la generation du squelette)
     */
    public List<Interface> getInterfaces(){
        ArrayList<Interface> in=new ArrayList<>();
        if(this.getC()!=null){
            Class[] inter=this.getC().getInterfaces();
            for (int i = 0; i < inter.length; i++) {
                in.add(new Interface(inter[i]));
            }
            for (Relation r:this.relations) {
                //Todo : verifier que les relations ne sont pas deja placées et les ajouter dans la liste des parents si necessaire
            }
        }
        return in;
    }
}