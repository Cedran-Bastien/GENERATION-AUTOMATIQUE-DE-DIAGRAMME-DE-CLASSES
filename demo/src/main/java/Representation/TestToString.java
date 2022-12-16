package Representation;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToString {
    @Test
    public void testMethod(){
        Methode methode=new Methode("testeur","int");
            assertEquals(methode.toString(),"public testeur():int");
    }
    @Test
    public void testAttribut(){
Attribut attribut=new Attribut("testeur","int");
assertEquals(attribut.toString(),"public testeur int");
    }
}
