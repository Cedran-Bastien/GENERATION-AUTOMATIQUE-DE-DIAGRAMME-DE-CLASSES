
import Representation.Heritage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHeritage {

    @Test
    public void test(){
        //preparation des donnés
        Heritage h =new Heritage("classeSource", "classeCible");

        //methode testé
        String test = h.toString();

        //test
        Assertions.assertEquals("",test);
    }
}
