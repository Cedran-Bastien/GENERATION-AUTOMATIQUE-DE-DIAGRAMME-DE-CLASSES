import Representation.Modele;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import javax.sound.midi.Soundbank;
import java.io.IOException;

public class TestModele {
    Modele m;
    @BeforeEach
    public void init() throws IOException, ClassNotFoundException {
        m=new Modele("C:\\Users\\Didier\\Desktop\\k");
    }
    @Test
    public void TestHeritage() throws IOException, ClassNotFoundException {
        init();
        System.out.println(m.toString());
    }
}
