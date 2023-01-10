package Vue;

import Representation.*;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.List;

public class VueInstance extends VBox implements Observer {
    private Instance instance;
    VBox border;
    VBox nomType;
    VBox attributs;
    VBox methode;

    /**
     * Constructeur renant une instance
     *
     * @param inst
     */
    public VueInstance(Instance inst) {
        instance = inst;
        this.Construction();
    }

    /**
     * Methode actualisant les objet javaFX de la classe
     */
    @Override
    public void actualiser() {
        this.getChildren().clear();
        this.Construction();
    }

    public void placerClasse(int x, int y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public Instance getInstance() {
        return instance;
    }

    /**
     * Methode construisant la boite
     */
    public void Construction() {
        border = new VBox();
        nomType = new VBox();
        attributs = new VBox();
        methode = new VBox();

        nomType.getChildren().add(new Text(instance.getNom()));
        nomType.getChildren().add(new Text(instance.getType()));
        nomType.setAlignment(Pos.CENTER);

        List<Attribut> att = instance.getAttributs();
        for (int i = 0; i < att.size(); i++) {
            System.out.println(att.get(i).toString());
            String texte = att.get(i).toString();
            texte = texte.replace("public", "+");
            texte = texte.replace("private", "-");
            texte = texte.replace("protected", "-");
            attributs.getChildren().add(new Text(texte));
        }

        List<Methode> meth = instance.getMethodes();
        for (int i = 0; i < meth.size(); i++) {
            String texte = meth.get(i).toString();
            texte = texte.replace("public", "+");
            texte = texte.replace("private", "-");
            texte = texte.replace("protected", "-");
            methode.getChildren().add(new Text(texte));
        }

        border.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));
        nomType.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        attributs.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        methode.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

        border.getChildren().addAll(nomType, attributs, methode);
        this.placerClasse(this.instance.getX(), this.instance.getY());
        getChildren().add(border);
        if (Modele.courante==null||!this.instance.equals(Modele.courante)) {
            this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        }else{
            this.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
        }

    }


}
