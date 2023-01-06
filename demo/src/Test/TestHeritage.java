
import Representation.Classe;
import Representation.Heritage;
import Representation.Instance;
import Representation.Relation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHeritage {

    @Test
   public void test(){
        //preparation des donnés
        Heritage h =new Heritage((Instance)new Classe(Heritage.class), (Instance)new Classe(Relation.class));

        //methode testé
        String test = h.toString();

        //test
        Assertions.assertEquals("la classe Representation.Heritage herite de la classe Representation.Relation",test);

        //Test avec un java.
        h=new Heritage(new Classe(Heritage.class),new Classe(ClassLoader.class));
        test=h.toString();
        Assertions.assertEquals("la classe Representation.Heritage herite de la classe ClassLoader",test);

    }
}
