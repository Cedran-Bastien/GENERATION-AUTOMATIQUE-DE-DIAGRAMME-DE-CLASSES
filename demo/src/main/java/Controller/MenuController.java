package Controller;

import Representation.Instance;
import Representation.Menu;
import Representation.Modele;
import Vue.VueMenu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuController implements EventHandler {
    Stage stage;
    Modele mod;

    //certaine variable doive etre declarer en dehors du handler pour ne pas etre oublier
    boolean afficheExporte = Boolean.FALSE;
    boolean afficheCacher = Boolean.FALSE;
    VueMenu vueChoixFormat = null;
    VueMenu vueElementsCacher = null;
    List<String> elementsCacherNom = new ArrayList<>();
    HashMap<String, Instance> elementsCacher = new HashMap<>();
    private static MenuController menuController;

    public MenuController(Stage s){
        stage = s;
        menuController = this;
    }

    public static MenuController getInstance(){
        return menuController;
    }

    public MenuController(Stage s, Modele mod){
        stage = s;
        this.mod = mod;
    }

    @Override
    public void handle(Event event) {
        VBox source = (VBox) event.getSource();
        Text text = (Text) source.getChildren().get(0);

        Pane pane = (Pane) stage.getScene().getRoot();
        SelecteurDossier selecteurDossier = (SelecteurDossier) pane.getChildren().get(0);
        Modele modele = selecteurDossier.getModele();

        //Le switch recupere le texte presser pour agir en consecense
        switch (text.getText()) {
            case "test":
                System.out.println("Marche");
                break;

            //Menu principale
            case "Changer Repertoire":
                selecteurDossier.handle(event);
                break;
            case "Exporter":
                if (!afficheExporte) {
                    List<String> formats = new ArrayList<>();
                    formats.add("JPEG");
                    formats.add("PNG");
                    Menu choixFormat = new Menu(formats, Boolean.TRUE, (int) source.getLayoutX(),20);
                    vueChoixFormat = new VueMenu(choixFormat, this);
                    vueChoixFormat.actualiser();
                    pane.getChildren().add(vueChoixFormat);
                    afficheExporte = Boolean.TRUE;
                } else {
                    pane.getChildren().remove(vueChoixFormat);
                    afficheExporte = Boolean.FALSE;
                }
                break;
            case "Afficher":
                if (!afficheCacher) {
                    Menu menuElementsCacher = new Menu(elementsCacherNom,Boolean.TRUE,(int) source.getLayoutX(),20);
                    vueElementsCacher = new VueMenu(menuElementsCacher,this);
                    pane.getChildren().add(vueElementsCacher);
                    afficheCacher = Boolean.TRUE;
                } else {
                    pane.getChildren().remove(vueElementsCacher);
                    afficheCacher = Boolean.FALSE;
                }
                break;
            case "Ajouter classe":
                //todo
                break;
            case "Generer squellette":
                modele.exporterSquellette();
                break;

            case "Cacher instance":
                modele.getCourante().setAfficherInstance(Boolean.FALSE);
                elementsCacher.put(modele.getCourante().getType() + " " + modele.getCourante().getNom(),modele.getCourante());
                elementsCacherNom.add(modele.getCourante().getType() + " " + modele.getCourante().getNom());
                break;
            case "Cacher methodes":
                modele.getCourante().setAfficherMethode(Boolean.FALSE);
                elementsCacher.put("Methodes " + modele.getCourante().getNom(),modele.getCourante());
                elementsCacherNom.add("Methodes " + modele.getCourante().getNom());
                break;
            case "Cacher attributs":
                modele.getCourante().setAfficherAttributs(Boolean.FALSE);
                elementsCacher.put("Attributs " + modele.getCourante().getNom(),modele.getCourante());
                elementsCacherNom.add("Attributs " + modele.getCourante().getNom());
                break;
            case "JPEG":
                //TODO
                break;
            case "PNG":
                //TODO
                break;
            default:
                for(int i = 0;i < elementsCacherNom.size();i++){
                    if(text.getText().startsWith("Classe") || text.getText().startsWith("Interface")){
                        elementsCacher.get(text).setAfficherInstance(Boolean.TRUE);
                        elementsCacher.remove(text);
                        elementsCacherNom.remove(text);
                    } else if (text.getText().startsWith("Methodes")) {
                        elementsCacher.get(text).setAfficherMethode(Boolean.TRUE);
                        elementsCacher.remove(text);
                        elementsCacherNom.remove(text);
                    } else if (text.getText().startsWith("Attributs")) {
                        elementsCacher.get(text).setAfficherAttributs(Boolean.TRUE);
                        elementsCacher.remove(text);
                        elementsCacherNom.remove(text);
                    }
                }
                break;
        }
    }
}
