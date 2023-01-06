package Representation;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestToString {

    public interface inter {
        int n = 3;

        public abstract int getn();
    }

    public abstract class inter2 {
        int n = 3;
        Relation x;

        public abstract int getn();
    }

    @Test
    public void testMethod() {
        Methode methode = new Methode("testeur", "int".getClass());
        assertEquals(methode.toString(), "public testeur():String");
        ArrayList liste = new ArrayList<Relation>(0);
        methode = new Methode("testeur", new String[][]{{"a"}, {"a"}}.getClass());
        assertEquals(methode.toString(), "public testeur():String[][]");
        methode = new Methode("testeur", Relation.class, new Class[]{Relation.class, Loaders.class});
        assertEquals(methode.toString(), "public testeur(Representation.Relation,Representation.Loaders):Representation.Relation");
    }

    @Test
    public void testAttribut() {
        Attribut attribut = new Attribut("testeur", "a".getClass());
        assertEquals(attribut.toString(), "public testeur String");
        attribut = new Attribut("testeur", new String[][]{{"a"}, {"a"}}.getClass());
        assertEquals(attribut.toString(), "public testeur String[][]");
    }

    @Test
    public void testInterface() {
        Interface i = new Interface(inter.class);
        String verify = "protected Interface:inter \n" +
                "attributs:\n" +
                "public n:int\n" +
                "-------------\n" +
                "methodes: \n" +
                "public getn():int\n" +
                "--------------";
        assertEquals(verify, i.toString());
    }

    @Test
    public void TestClasse() {
        Classe i = new Classe(inter2.class);
        String verify =
                "public abstract Classe Representation.TestToString$inter2\n" +
                        "attributs:\n" +
                        "public n:int\n" +
                        "public x:Representation.Relation\n" +
                        "public this$0:Representation.TestToString\n" +
                        "-------------\n" +
                        "methodes: \n" +
                        "public getn():int\n" +
                        "--------------";
        assertEquals(verify, i.toString());
    }
}
