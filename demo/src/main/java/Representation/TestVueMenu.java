package Representation;

import Vue.VueMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

public class TestVueMenu extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        List<String> l = new ArrayList<String>();
        l.add("Premier");
        l.add("Second");
        l.add("Dernier");
        Menu m = new Menu(l,Boolean.FALSE,10,10);
        VueMenu vM =  new VueMenu(m);
        vM.actualiser();
        root.getChildren().addAll(vM);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}