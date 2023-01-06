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
    public void test(){
        //preparation des donnés
        Implementation i =new Implementation(new Classe(ArrayList.class),new Interface(List.class));

        //methode testé
        String test = i.toString();

        //test
        Assertions.assertEquals("la classe Arraylist implemente l'interface List",test);
    }
}