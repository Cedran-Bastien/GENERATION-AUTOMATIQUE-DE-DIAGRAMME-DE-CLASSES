import Representation.Heritage;
import Representation.Implementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestImplementation {

    @Test
    public void test(){
        //preparation des donnés
        Implementation i =new Implementation("classeSource", "classeCible");

        //methode testé
        String test = i.toString();

        //test
        Assertions.assertEquals("",test);
    }
}