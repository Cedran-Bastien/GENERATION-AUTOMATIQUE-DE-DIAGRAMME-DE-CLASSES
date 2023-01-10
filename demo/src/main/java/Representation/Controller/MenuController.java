package Representation.Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MenuController implements EventHandler {

    @Override
    public void handle(Event event) {
        Text source = (Text) event.getSource();

        //Le switch recupere le texte presser pour agir en consecense
        switch (source.getText()){
            case "test":
                System.out.println("Marche");
                break;
        }
    }
}
