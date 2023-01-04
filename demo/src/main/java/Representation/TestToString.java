package Representation;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestToString {

    public interface inter {
        int n = 3;

        public abstract int getn();
    }

    public abstract class inter2 {
        int n = 3;

        public abstract int getn();
    }

    @Test
    public void testMethod() {
        Methode methode = new Methode("testeur", "int");
        assertEquals(methode.toString(), "public testeur():int");
    }

    @Test
    public void testAttribut() {
        Attribut attribut = new Attribut("testeur", "int");
        assertEquals(attribut.toString(), "public testeur int");
    }

    @Test
    public void testInterface() {
        Interface i = new Interface(inter.class);
        String verify = "protected Interface Representation.TestToString$inter\n" +
                "attributs:\n" +
                "public int\n" +
                "-------------\n" +
                "methodes: \n" +
                "public getn():int\n" +
                "--------------";
        System.out.println(i.toString());
        assertEquals(verify, i.toString());
    }

    @Test
    public void TestClasse() {
        Classe i = new Classe(inter2.class);
        String verify =
                "public abstract Classe Representation.TestToString$inter2\n" +
                        "attributs:\n" +
                        "public int\n" +
                        "public Representation.TestToString\n" +
                        "-------------\n" +
                        "methodes: \n" +
                        "public getn():int\n" +
                        "--------------";
        System.out.println(i.toString());
        assertEquals(verify, i.toString());
    }
}
