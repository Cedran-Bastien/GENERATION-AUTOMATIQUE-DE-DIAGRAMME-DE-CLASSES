package Vue;

import Controller.MenuController;
import Representation.Menu;
import Representation.Observer;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

public class VueMenu extends VBox implements Observer{
    Menu menu;

    /**
     * Constructeur prenant un menu
     * @param m
     */
    public VueMenu(Menu m){
        menu = m;
    }

    /**
     * Methode actualisant les objet javaFX de la classe
     */
    @Override
    public void actualiser() {
        Pane bordure;
        if(menu.getOrientation()){
            bordure = new VBox();
        }else{
            bordure = new HBox();
        }
        List<String> elements = menu.getElements();
        for(int i = 0;i < elements.size();i++){
            VBox vB = new VBox();
            Text t = new Text(elements.get(i));
            t.setOnMousePressed(new MenuController());
            vB.getChildren().add(t);
            vB.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
            bordure.getChildren().add(vB);
        }
        bordure.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        this.getChildren().add(bordure);
        this.setLayoutX(menu.getX());
        this.setLayoutY(menu.getY());
    }
}
