package Representation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Globale {
    protected String nom;
    protected int modifier;

    public String getNom() {
        return nom;
    }

    public int getModifier() {
        return modifier;
    }

    public String getAcces() {
        if(Modifier.isPrivate(this.modifier)){
            return "private";
        } else if (Modifier.isPublic(this.modifier)) {
            return "protected";
        } else {
            return "public";
        }
    }
    /**
     * Methode clarifiant les nom de classe
     */
    public String cleaner(Class c){
        String retour;
        if (c.getName().contains("java.")) {
            retour=c.getSimpleName();
        }else {
            retour= c.getName();
        }
        return retour;
    }
    public String StringCleaner(String s,Class c){
        return s.replace(c.getName(),c.getSimpleName());

    }

    @Override
    public boolean equals(Object obj) {
        Globale globale=(Globale) obj;
        return this.nom==globale.nom&&this.modifier==globale.modifier;
    }
    /**
     * Methode renvoyant la structure de donnee qui compose la classe de lattribut
     * (solution pour la gestion de liste)
     * @return
     */
    public static String dataStructure(Instance i,Attribut a) throws ClassNotFoundException {
        //todo :faire gestion structure des listes
        String retour="";
        retour=a.getType().getCanonicalName();
        if(retour=="java.util.List") {
            for (Field f:i.getC().getDeclaredFields()) {
            }
            Instance attribut = a.getInstance();
            Field[] fields = i.getC().getDeclaredFields();
            for (Field f : fields) {
                if (f.getName() == a.getNom()) {
                    retour = f.getGenericType().getTypeName();
                }
            }
        }
        return retour;
    }
}
