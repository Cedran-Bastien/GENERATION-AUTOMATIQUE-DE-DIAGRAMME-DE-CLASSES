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
        Assertions.assertEquals("\nla classe classeSource contient un attribut de la classe classeCible de nom 'essaie'",test);
    }

    @Test
    public void test_toString_n_sup_1(){
        //preparation des donnés
        Association h =new Association("classeSource", "classeCible","1","*","essaie");
        Association h2 =new Association("classeSource", "classeCible","1","1..3","essaie");
        Association h3 =new Association("classeSource", "classeCible","1","*","essaie");


        //methode testé
        String test = h.toString();
        String test2 = h2.toString();
        String test3 = h3.toString();

        //test
        Assertions.assertEquals("\nla classe classeSource contient une liste d'objets de la classe classeCible de nom 'essaie'",test);
        Assertions.assertEquals("\nla classe classeSource contient entre 1 et 3 attributs de la classe classeCible de nom 'essaie'",test2);
        Assertions.assertEquals("\nla classe classeSource contient une liste d'objets de la classe classeCible de nom 'essaie'",test3);

    }
}
