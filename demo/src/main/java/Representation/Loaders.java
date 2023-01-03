package Representation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.nio.file.Files;

/**
 * class chargeant la class du projet
 */
public class Loaders extends ClassLoader {
    public Class loadFromFile(File file) throws IOException {
        byte[] b = Files.readAllBytes(file.toPath());
        return this.defineClass(null, b, 0, b.length);
    }

    /**
     * Main servant d'exemple d'utilisation
     * @param args
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        File file = new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\test\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\TestToString.class");
        Class c=new Loaders().loadFromFile(file);
        System.out.println(c.getName());
    }
}