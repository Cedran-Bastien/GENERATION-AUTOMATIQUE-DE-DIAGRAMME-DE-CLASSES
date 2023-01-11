package Representation;

import Representation.Modele;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, NoSuchFieldException {
        Modele m =new Modele("E:\\Informatique\\Etude\\S3\\Qualité_de_developpement\\MVC_\\target\\classes\\com\\example\\mvc_");
        System.out.println(m.getClasseInit().size());
        System.out.println(m);
    }
}
