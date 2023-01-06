package Vue;

import Representation.Classe;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.lang.reflect.Method;

public class VueClasse extends VBox {
    private Rectangle en_tete;
    private Rectangle attribut;
    private Rectangle methode;

    public VueClasse(Classe c){
        String n = c.getNom();
        Label l = new Label(n+"\n dfsqfsdf");
        l.getLayoutX();
        double height =  (int) (l.getHeight())+ 20;
        double width = (int)(l.getWidth())+10;
        this.en_tete = new Rectangle(width,height);
        this.en_tete.setFill(Color.WHITE);
        this.en_tete.setStroke(Color.BLACK);
        this.en_tete.setAccessibleText("bkjfdwncbnw,dnbwkdjxc,v ;,wdnx");
        StackPane sp = new StackPane();
        sp.getChildren().addAll(this.en_tete,l);

        this.getChildren().add(sp);
    }


}
