package Representation;

import Representation.Modele;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchFieldException {
        Modele m =new Modele("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES");
        //System.out.println(m.getClasseInit().size());
        System.out.println(m);
    }
}
