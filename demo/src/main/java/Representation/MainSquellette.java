package Representation;

import java.io.File;
import java.io.IOException;

public class MainSquellette {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Modele m =new Modele("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\Representation");
        Instance i = new Classe(new Loaders().loadFromFile(new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\Representation\\Instance.class")));
        System.out.println(i.getSquellette());
    }
}
