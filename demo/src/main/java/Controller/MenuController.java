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
    Modele modele;

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
        modele = mod;
        menuController = this;
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
                    vueElementsCacher.actualiser();
                    pane.getChildren().add(vueElementsCacher);
                    afficheCacher = Boolean.TRUE;
                } else {
                    pane.getChildren().remove(vueElementsCacher);
                    afficheCacher = Boolean.FALSE;
                }
                break;
            case "Generer squellette":
                modele.exporterSquellette();
                break;

            case "JPEG":
                try {
                    this.modele.enregistrementDiagramme(Modele.JPEG_FORMAT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "PNG":
                try {
                    this.modele.enregistrementDiagramme(Modele.PNG_FORMAT);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                for(int i = 0;i < elementsCacherNom.size();i++){
                    if(text.getText().startsWith("Classe") || text.getText().startsWith("Interface")){
                        System.out.println(elementsCacher.toString());
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

    public void gestionMenuContextuelle(String action,Instance instance){
        switch (action){
            case "Cacher instance":
                if(instance.getAfficherInstance()) {
                    instance.setAfficherInstance(Boolean.FALSE);
                    elementsCacher.put(instance.getType() + " " + instance.getNom(), instance);
                    System.out.println(instance.toString());
                    elementsCacherNom.add(instance.getType() + " " + instance.getNom());
                }
                break;
            case "Cacher methodes":
                if(instance.getAfficherMethode()) {
                    modele.getCourante().setAfficherMethode(Boolean.FALSE);
                    elementsCacher.put("Methodes " + instance.getNom(), instance);
                    elementsCacherNom.add("Methodes " + instance.getNom());
                }
                break;
            case "Cacher attributs":
                if(instance.getAfficherAttributs()) {
                    modele.getCourante().setAfficherAttributs(Boolean.FALSE);
                    elementsCacher.put("Attributs " + instance.getNom(), instance);
                    elementsCacherNom.add("Attributs " + instance.getNom());
                }
                break;
        }
    }
}
