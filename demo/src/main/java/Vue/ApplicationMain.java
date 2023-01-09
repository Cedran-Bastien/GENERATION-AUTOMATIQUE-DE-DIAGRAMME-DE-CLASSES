package Vue;

import Representation.Classe;
import Representation.Loaders;
import Representation.Modele;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationMain extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        Loaders l = new Loaders();
        Pane p = new Pane();
        Modele m = new Modele("E:\\Informatique\\Etude\\S3\\SAE\\SAE_Dev\\GENERATION-AUTOMATIQUE-DE-DIAGRAMME-DE-CLASSES\\demo\\target\\classes\\Representation",p);



        Scene scene = new Scene(p);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        m.genererGraphe();
    }
}
