package Controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;

public class MenuContextuelleControlleur implements EventHandler {

    @Override
    public void handle(Event event) {
        MenuItem source = (MenuItem) event.getSource();
        String action = source.getText();
        MenuController.getInstance().gestionMenuContextuelle(action);
    }
}
