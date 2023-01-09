package Representation.Controller;

import Representation.Modele;
import Representation.Observer;
import Vue.VueInstance;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe etant le controleur permettant de choisir le dossier du projet à partir duquel on crée le modele
 */
public class SelecteurDossier extends VBox implements EventHandler {
    //Todo Singleton pour eviter les duplications
    //Todo trouver moyen d'ajouter le selectionneur
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
        String[]tab={"Changer Repertoire","Exporter","Afficher","Ajouter classe","Generer squellette"};
        HBox menu = new HBox();
        //todo:recuperer controleur menu de romain
        this.setAlignment(Pos.TOP_LEFT);
        for (String s:tab) {
            menu.getChildren().add(new Button(s));
        }
        menu.getChildren().get(0).setOnMouseClicked(this);
        this.getChildren().add(menu);
        modele.AffichageDesInstances();
        //todo:recuperer affichage de Cedran
        for (Observer o : this.modele.observateursInstance) {
            this.getChildren().add((Node) o);
        }

    }
    public void reset(){
        this.getChildren().clear();
    }

    @Override
    public void handle(Event event) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        try {
            this.modele = new Modele(directoryChooser.showDialog(stage).getAbsolutePath());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.reset();
        this.affichageFichier();
    }
    }
