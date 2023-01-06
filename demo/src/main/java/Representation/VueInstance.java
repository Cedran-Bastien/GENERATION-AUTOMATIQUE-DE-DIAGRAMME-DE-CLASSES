package Representation;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

public class VueInstance extends Observer{
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
            attributs.getChildren().add(new Text(att.get(i).toString().replace("public","+").replace("private","-").replace("protected","-")));
        }

        List<Methode> meth = instance.getMethodes();
        for(int i = 0;i < meth.size();i++){
            methode.getChildren().add(new Text(meth.get(i).toString().replace("public","+").replace("private","-").replace("protected","-")));
        }

        border.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        nomType.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        attributs.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        methode.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

        border.getChildren().addAll(nomType,attributs,methode);
        getChildren().add(border);
    }
}
