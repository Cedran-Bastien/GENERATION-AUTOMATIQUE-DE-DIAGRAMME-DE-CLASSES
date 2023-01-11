import Representation.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestdataStructure {
    @Test
    public void testDataStructure() throws IOException {
        Instance i=new Classe(new Loaders().loadFromFile(new File("C:\\xampp\\htdocs\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\out\\production\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\Representation\\Instance.class")).get(0));
        for (Attribut a:i.getAttributs()) {
            System.out.println(Globale.dataStructure(i,a));
        }
    }
}
