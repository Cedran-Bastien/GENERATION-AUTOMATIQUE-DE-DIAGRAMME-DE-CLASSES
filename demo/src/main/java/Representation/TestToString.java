package Representation;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToString {
    private interface inter {
        int n = 3;

        public int getn();
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
        String verify = "private I inter\n" +
                "public final static int n\n" +
                "public getn()";
        System.out.println(i.toString());    }

    @Test
    public void TestClasse() {
        Classe i;
    }
}
