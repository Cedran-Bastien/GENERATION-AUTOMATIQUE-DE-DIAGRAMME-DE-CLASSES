package Controller;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;

public class ControllerInstance implements EventHandler {
    Boolean afficher = false;
    @Override
    public void handle(Event event) {
        List<String> option = new ArrayList<>();
        option.add("Cacher Instance");
        option.add("Cacher methodes");
        option.add("Cacher attributs");

    }
}
