package Representation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * class chargeant la class du projet
 */
public class Loaders extends ClassLoader {
    URLClassLoader urlClassLoader;
    List<String> nomBin = new ArrayList<>();

    public Loaders() {

    }

    public List<Class> loadFromFile(File file) throws IOException {
        List<Class> classes = new ArrayList<>();
        URL[] urls = new URL[]{file.toURI().toURL()};
        this.urlClassLoader = new URLClassLoader(urls);
        this.getClassChemin(file, "");
        try {
            for (String c : this.nomBin) {
                if (!c.equals("module-info")) {
                    classes.add(this.urlClassLoader.loadClass(c));
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return classes;
    }

    /**
     * Methode reprenant le chemin avec des points
     */
    public void getClassChemin(File projet, String chemin) throws IOException {
        String path = "";
        File[] file = projet.listFiles();
        if (projet.isDirectory()) {
            for (File f : file) {
                if (f.isDirectory()) {
                    getClassChemin(f, chemin + f.getName() + ".");
                } else {
                    if (f.getName().endsWith(".class")) {
                        this.nomBin.add((chemin + f.getName()).replace(".class", ""));
                    }
                }
            }
        } else {
            if (projet.getName().endsWith(".class")) {
                this.nomBin.add((chemin + projet.getName()).replace(".class", ""));
            }
        }
    }

    /**
     * Main servant d'exemple d'utilisation
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        File file = new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES");
        Loaders l = new Loaders();
        l.getClassChemin(file, "");
        System.out.println(l.loadFromFile(file).get(0).getName());
    }
}