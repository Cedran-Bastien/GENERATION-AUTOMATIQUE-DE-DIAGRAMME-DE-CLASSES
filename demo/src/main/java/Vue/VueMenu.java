package Vue;

import Controller.MenuController;
import Representation.Menu;
import Representation.Observer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

import static javafx.scene.paint.Color.DEEPPINK;

public class VueMenu extends VBox implements Observer{
    Menu menu;
    MenuController menuController;

    /**
     * Constructeur prenant un menu
     * @param m
     */
    public VueMenu(Menu m,MenuController mC){
        menu = m;
        menuController = mC;
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
            vB.getChildren().add(t);
            vB.setAlignment(Pos.CENTER);
            vB.setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID, new CornerRadii(2), new BorderWidths(3))));
            vB.setBackground(new Background(new BackgroundFill(Color.MINTCREAM,new CornerRadii(2), Insets.EMPTY)));
            vB.setOnMousePressed(menuController);
            bordure.getChildren().add(vB);
        }
        this.getChildren().add(bordure);
        this.setLayoutX(menu.getX());
        this.setLayoutY(menu.getY());
    }
}
