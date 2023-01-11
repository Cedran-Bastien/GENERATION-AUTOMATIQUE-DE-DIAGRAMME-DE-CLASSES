import Representation.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestModele {
    Modele m;
    Instance i;
    Instance j;

    @BeforeEach
    public void init() throws IOException, ClassNotFoundException {
        m = new Modele("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\Representation");
        i = new Classe(new Loaders().loadFromFile(new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\Representation\\Instance.class")).get(0));
        j = new Classe(new Loaders().loadFromFile(new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\test\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\TestModele.class")).get(0));
    }

    @Test
    public void TestModele() throws IOException, ClassNotFoundException {
        init();
        //Test pour tester la presence des instances
        assertEquals(22, m.getClasseInit().size());
        //Test de presence des Instances deja chargées
        assertTrue(m.getClasseInit().contains(i));
        assertFalse(m.getClasseInit().contains(j));
    }
    @Test
    public void testRelation() throws IOException, ClassNotFoundException {
        init();
        Instance i3=new Classe(new Loaders().loadFromFile(new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\Representation\\Instance.class")));
        Instance i4=m.getClasseInit().get(m.getClasseInit().indexOf(i3));
        System.out.println(i4);
    }

}
