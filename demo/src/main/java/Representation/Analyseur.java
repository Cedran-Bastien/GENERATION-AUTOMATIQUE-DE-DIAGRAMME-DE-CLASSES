package Representation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;

public class Analyseur {
    public void AnalyseClasse(String nomClasse) throws ClassNotFoundException, IOException {
        File repertoire = new File(nomClasse);
        System.out.println(repertoire.isDirectory());
        File[] fichiers = repertoire.listFiles();
        //On identifie l'extension du fichier
        if (true) {
            Path temp = Files.createTempDirectory( "temp1");

            for (File fichier :
                    fichiers) {
                Class c = Class.forName("E:.Informatique.Etude.S3.Qualité_de_developpement.TD9_Composite.src.Societe.java");
                String name = c.getSimpleName();
                String[] name2 = name.split("\\.");
                name = name2[name2.length - 1];
                Field[] paramPublic = c.getFields();
                Field[] paramPrivé = c.getDeclaredFields();
                Method[] me = c.getMethods();
                int m = c.getModifiers();

                System.out.println(Modifier.toString(m) + " " + name);

                System.out.println("-----");

                for (int i = 0; i < paramPublic.length; i++) {
                    System.out.println("+" + paramPublic[i].getClass() + " :" + paramPublic[i].getName());
                }
                for (int i = 0; i < paramPrivé.length; i++) {
                    String mod = Modifier.toString(paramPrivé[i].getModifiers());
                    String type = String.valueOf(paramPrivé[i].getType());
                    String[] type2 = type.split("\\.");
                    type = type2[type2.length - 1];
                    System.out.println(mod + "  " + type + " :" + paramPrivé[i].getName());
                }
                System.out.println("-----");
                for (int i = 0; i < me.length; i++) {
                    String type = String.valueOf(me[i].getAnnotatedReturnType().getType());
                    String mod = Modifier.toString(me[i].getModifiers());
                    String[] type2 = type.split("\\.");
                    type = type2[type2.length - 1];
                    System.out.println(mod + " " + me[i].getName() + "():" + type);
                }
            }
            Files.deleteIfExists(temp);
        }
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Analyseur a = new Analyseur();
        a.AnalyseClasse("C:\\Users\\Didier\\Desktop\\demoSAE\\src\\main\\java\\com\\example\\demosae");
    }
}
