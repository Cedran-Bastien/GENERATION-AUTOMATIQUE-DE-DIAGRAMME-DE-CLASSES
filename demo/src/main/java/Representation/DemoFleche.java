package Representation;

import Vue.VueAssociation;
import Vue.VueHeritage;
import Vue.VueImplementation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class DemoFleche extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Heritage f = new Heritage(10,10,50,50);
        Heritage f2 = new Heritage(80,10,80,80);
        Association f3 = new Association(100,100,158,100,"debut","fin");
        Association f4 = new Association(180,170,40,170,"Start","End");
        Implementation f5 = new Implementation(50,200,200,350);
        Implementation f6 = new Implementation(50,380,50,250);
        VueHeritage vF1 = (VueHeritage) f.getImage();
        VueHeritage vF2 = (VueHeritage) f2.getImage();
        VueAssociation vF3 = new VueAssociation(f3);
        VueAssociation vF4 = new VueAssociation(f4);
        VueImplementation vF5 = new VueImplementation(f5);
        VueImplementation vF6 = new VueImplementation(f6);
        vF1.actualiser();
        vF2.actualiser();
        vF3.actualiser();
        vF4.actualiser();
        vF5.actualiser();
        vF6.actualiser();
        root.getChildren().addAll(vF1,vF2,vF3,vF4,vF5,vF6);
        Scene scene = new Scene(root, 210, 400);
        stage.setTitle("fleche");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
