package Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController implements EventHandler {
    Stage stage;



    public MenuController(Stage s){
        stage = s;
    }

    @Override
    public void handle(Event event) {
        VBox source = (VBox) event.getSource();
        Text text = (Text) source.getChildren().get(0);

        //Le switch recupere le texte presser pour agir en consecense
        switch (text.getText()){
            case "test":
                System.out.println("Marche");
                break;

        //Menu principale
            case "Changer Repertoire":
                Pane p = (Pane) stage.getScene().getRoot();
                SelecteurDossier sD = (SelecteurDossier) p.getChildren().get(0);
                sD.handle(event);
                break;
            case "Exporter":
                //todo
                break;
            case "Afficher":
                //todo
                break;
            case "Ajouter classe":
                //todo
                break;
            case "Generer squellette":
                //todo
                break;

        //autre
        }
    }
}
