import Representation.Attribut;
import Representation.Methode;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestToString {
    @Test
    public void testMethod(){
       // Methode methode=new Methode("testeur","int".getClass(), m.getParameterTypes());
     //   assertEquals(methode.toString(),"public testeur():int");
    }
    @Test
    public void testAttribut(){
        Attribut attribut=new Attribut("testeur","int".getClass());
        assertEquals(attribut.toString(),"public testeur int");
    }
}
