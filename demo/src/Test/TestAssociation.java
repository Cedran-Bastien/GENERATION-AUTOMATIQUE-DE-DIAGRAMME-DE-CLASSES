import Representation.Association;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAssociation {
    @Test
    public void test_toString_un_seul_attribut(){
        //preparation des donnés
        Association h =new Association("classeSource", "classeCible","1","1","essaie");

        //methode testé
        String test = h.toString();

        //test
        Assertions.assertEquals("",test);
    }

    @Test
    public void test_toString_n_sup_1(){
        //preparation des donnés
        Association h =new Association("classeSource", "classeCible","1","1","essaie");

        //methode testé
        String test = h.toString();

        //test
        Assertions.assertEquals("",test);
        //TODO -> remplir expected
    }
}
