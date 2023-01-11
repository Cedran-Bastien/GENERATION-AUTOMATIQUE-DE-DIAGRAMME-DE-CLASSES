package Representation;

import Vue.VueAssociation;
import Vue.VueInstance;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TextVueInstance extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox();
        Classe c = new Classe(VueAssociation.class);
        Classe c2 = new Classe(Classe.class);
        Classe c3 = new Classe(Heritage.class);
        Interface c4 = new Interface(Observer.class);
        VueInstance vue = c.getImage();
        VueInstance vue2 = c2.getImage();
        VueInstance vue3 = c3.getImage();
        VueInstance vue4 = c4.getImage();
        vue.actualiser();
        vue2.actualiser();
        vue3.actualiser();
        vue4.actualiser();
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        v1.getChildren().addAll(vue,vue2);
        v2.getChildren().addAll(vue3,vue4);
        root.getChildren().addAll(v1,v2);
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Instance");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
