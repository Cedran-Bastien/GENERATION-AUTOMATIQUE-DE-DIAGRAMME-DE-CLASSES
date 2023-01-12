import Representation.Classe;
import Representation.Heritage;
import Representation.Implementation;
import Representation.Interface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestImplementation {

    @Test
    public void test() throws ClassNotFoundException {

        //preparation des donnés
        Implementation i =new Implementation(new Interface(List.class));

        //methode testé
        String test = i.toString();

        //test
        Assertions.assertEquals("la classe ArrayList implemente l'interface List",test);
    }
}