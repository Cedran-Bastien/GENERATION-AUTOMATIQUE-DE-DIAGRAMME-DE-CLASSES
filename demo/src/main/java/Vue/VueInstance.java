package Vue;

import Representation.Attribut;
import Representation.Instance;
import Representation.Methode;
import Representation.Observer;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

public class VueInstance extends VBox implements Observer {
    private Instance instance;

    public VueInstance(Instance inst){
        instance = inst;
    }

    @Override
    public void actualiser() {
        VBox border = new VBox();
        VBox nomType = new VBox();
        VBox attributs = new VBox();
        VBox methode = new VBox();

        nomType.getChildren().add(new Text(instance.getNom()));
        nomType.getChildren().add(new Text(instance.getType()));
        nomType.setAlignment(Pos.CENTER);

        List<Attribut> att = instance.getAttributs();
        for(int i = 0;i < att.size();i++){
            System.out.println(att.get(i).toString());
            String texte = att.get(i).toString();
            texte.replace("public","+");
            texte.replace("private","-");
            texte.toString().replace("protected","-");
            attributs.getChildren().add(new Text(texte));
        }

        List<Methode> meth = instance.getMethodes();
        for(int i = 0;i < meth.size();i++){
            String texte = meth.get(i).toString();
            texte.replace("public","+");
            texte.replace("private","-");
            texte.toString().replace("protected","-");
            methode.getChildren().add(new Text(texte));
        }

        border.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        nomType.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        attributs.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        methode.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

        border.getChildren().addAll(nomType,attributs,methode);
        this.placerClasse(this.instance.getX(), this.instance.getY());
        getChildren().add(border);
    }

    public void placerClasse (int x,int y){
        this.setLayoutX(x);
        this.setLayoutY(x);
    }
}
