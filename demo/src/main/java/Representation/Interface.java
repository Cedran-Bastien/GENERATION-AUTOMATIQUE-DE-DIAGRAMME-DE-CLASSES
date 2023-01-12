package Representation;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Interface extends Instance {

    public Interface(Class c) throws ClassNotFoundException {
        super(c);
    }

    @Override
    public String getType() {
        return "Interface";
    }

    @Override
    public String toString() {
        return this.getAcces() + " Interface:" + this.nom + " " + super.toString();
    }

    @Override
    public String getSquellette() throws ClassNotFoundException {
        String phrase = Modifier.toString(this.modifier) + " interface " + this.nom;

        phrase += " extends ";
        List<Interface> parent = this.getParent();
        for (int i = 0; i < parent.size()-1; i++) {
            phrase += parent.get(i).getC().getSimpleName() + ",";
        }
        if (parent.size() > 0) {
            phrase += parent.get(parent.size()-1).getC().getSimpleName();
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
     * Une interface peut avoir plusieurs parents
     *
     * @return
     */
    public List<Interface> getParent() throws ClassNotFoundException {
        List<Interface> parent = new ArrayList<>();
        for (Relation r : this.relations) {
            if (r instanceof Heritage) {
                parent.add((Interface) r.classeCible);
            }
        }
        if (this.getC() != null) {
            Class[] tab = this.getC().getInterfaces();
            for (Class a : tab) {
                parent.add(new Interface(a));
            }
        }
        return parent;
    }
}
