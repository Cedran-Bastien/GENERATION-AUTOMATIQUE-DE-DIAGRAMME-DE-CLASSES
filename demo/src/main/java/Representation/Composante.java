package Representation;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;

public class Composante extends Globale{
    protected Class type;
    //attribut determinant le type en string grace a la classe de l'instance
    protected String retour;
    public Composante(String n,Class c){
        this.nom=n;
        this.type=c;
    }

    public void setRetour(String retours) {
        this.retour=this.StringCleaner(retours);
    }

    public Class getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Methode renvoyant la structure de donne qui compose la classe de lattribut
     * (solution pour la gestion de liste)
     * @return
     */
    public static String dataStructure(Instance i,Attribut a) {
        //todo :faire gestion structure des listes
        String retour = "";
        retour = a.getType().getSimpleName();
        if (retour == "java.util.List") {
            Instance attribut = a.getInstance();
            Field[] fields = i.getC().getDeclaredFields();
            for (Field f : fields) {
                if (f.getName() == a.getNom()) {
                    retour = f.getGenericType().toString();
                }
            }
            System.out.println(retour);
        }
            return retour;
        }

    public String getRetour() {
        return retour;
    }



}
