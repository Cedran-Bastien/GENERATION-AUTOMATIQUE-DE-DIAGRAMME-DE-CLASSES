package Controller;

import Representation.Menu;
import Representation.Modele;
import Representation.Observer;
import Vue.VueMenu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe etant le controleur permettant de choisir le dossier du projet à partir duquel on crée le modele
 */
public class SelecteurDossier extends VBox implements EventHandler {
    //Todo Singleton pour eviter les duplications
    Stage stage;
    Modele modele;

    public SelecteurDossier(Stage stage1) {
        this.stage = stage1;
        Button button = new Button("Choisir un dossier");
        Text text = new Text("Bienvenue");
        text.setFont(new Font("Verdana", 200));
        text.setBoundsType(TextBoundsType.LOGICAL);
        button.setOnMouseClicked(this);
        this.getChildren().addAll(text, button);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(600, 600);

    }

    public void affichageFichier() {
        List<String> tab = new ArrayList<>();
        tab.add("Changer Repertoire");
        tab.add("Exporter");
        tab.add("Afficher");
        tab.add("Ajouter classe");
        tab.add("Generer squellette");
        Menu menu = new Menu(tab, Boolean.FALSE,0,0);
        MenuController mC = new MenuController(stage);
        VueMenu vM = new VueMenu(menu,mC);
        vM.actualiser();
        this.setAlignment(Pos.TOP_LEFT);
        this.getChildren().add(vM);
        modele.genererGraphe();
        this.getChildren().add(modele.getPane());
        new SelectioneurInstance(this.modele);

    }
    public void reset(){
        this.getChildren().clear();
    }

    @Override
    public void handle(Event event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        try {
            this.modele = new Modele(directoryChooser.showDialog(stage).getAbsolutePath(),new Pane());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.reset();
        this.affichageFichier();
    }
    }
