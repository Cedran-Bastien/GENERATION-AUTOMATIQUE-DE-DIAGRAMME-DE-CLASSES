package Representation;

import Controller.MenuController;
import Vue.VueMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestMenuControlleur extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        List<String> l = new ArrayList<String>();
        l.add("test");
        l.add("Changer Repertoire");
        l.add("Dernier");
        List<String> l2 = new ArrayList<String>();
        l2.add("test");
        l2.add("Changer Repertoire");
        Menu m = new Menu(l,Boolean.FALSE,10,10);
        Menu m2 = new Menu(l2,Boolean.TRUE,100,100);
        MenuController mC = new MenuController(stage);
        VueMenu vM =  new VueMenu(m,mC);
        VueMenu vM2 = new VueMenu(m2,mC);
        vM.actualiser();
        vM2.actualiser();
        root.getChildren().addAll(vM,vM2);
        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
