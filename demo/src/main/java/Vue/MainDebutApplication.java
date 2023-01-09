package Vue;

import Representation.Controller.SelecteurDossier;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainDebutApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        SelecteurDossier s = new SelecteurDossier(stage);
        Pane p = new Pane();
        p.getChildren().add(s);
        Scene scene = new Scene(p);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
