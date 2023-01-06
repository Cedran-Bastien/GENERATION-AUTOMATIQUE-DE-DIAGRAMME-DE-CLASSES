package Representation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TextVueInstance extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Classe c = new Classe(VueAssociation.class);
        VueInstance vue = new VueInstance(c);
        vue.actualiser();
        root.getChildren().add(vue);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Instance");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
