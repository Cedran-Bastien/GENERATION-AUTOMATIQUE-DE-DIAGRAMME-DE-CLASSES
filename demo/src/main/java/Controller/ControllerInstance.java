package Controller;

import Representation.Instance;
import Representation.Menu;
import Vue.VueMenu;
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
        Instance inst = (Instance) event.getSource();
        Menu menu = new Menu(option,Boolean.TRUE, inst.getX(),inst.getY());
        VueMenu vueMenu = new VueMenu(menu,MenuController.getInstance());
        vueMenu.actualiser();
    }
}
