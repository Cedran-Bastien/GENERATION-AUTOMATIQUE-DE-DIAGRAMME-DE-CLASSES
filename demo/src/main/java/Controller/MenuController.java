package Controller;

import Representation.Instance;
import Representation.Menu;
import Representation.Modele;
import Vue.VueMenu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuController implements EventHandler {
    Stage stage;
    Modele modele;

    //certaine variable doive etre declarer en dehors du handler pour ne pas etre oublier
    boolean afficheExporte = Boolean.FALSE;
    boolean afficheCacher = Boolean.FALSE;
    VueMenu vueChoixFormat = null;
    VueMenu vueElementsCacher = null;
    List<String> instanceCacherNom = new ArrayList<>();

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
                    Menu menuElementsCacher = new Menu(instanceCacherNom,Boolean.TRUE,(int) source.getLayoutX(),20);
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
                if(text.getText().startsWith("Classe") || text.getText().startsWith("Interface")){
                    List<Instance> lI = modele.getClasseInit();
                    for(int i = 0;i < lI.size();i++){
                        if(text.getText() == lI.get(i).getType() + " " + lI.get(i).getNom()){
                            lI.get(i).setAfficherInstance(Boolean.TRUE);
                        }
                    }
                    instanceCacherNom.remove(text);
                }
                break;
        }
    }

    public void gestionMenuContextuelle(String action,Instance instance){
        switch (action){
            case "Cacher instance":
                if(instance.getAfficherInstance()) {
                    instance.setAfficherInstance(Boolean.FALSE);
                    System.out.println(instance.toString());
                    instanceCacherNom.add(instance.getType() + " " + instance.getNom());
                }
                break;
            case "Cacher methodes":
                if(instance.getAfficherMethode()) {
                    modele.getCourante().setAfficherMethode(Boolean.FALSE);
                    instanceCacherNom.add("Methodes " + instance.getNom());
                }
                break;
            case "Cacher attributs":
                if(instance.getAfficherAttributs()) {
                    instance.setAfficherAttributs(Boolean.FALSE);
                    instanceCacherNom.add("Attributs " + instance.getNom());
                }
                break;
            case "Afficher methodes":
                instance.setAfficherMethode(Boolean.TRUE);
                instanceCacherNom.remove(instance.getType() + " " + instance.getNom());
                break;
            case "Afficher attributs":
                instance.setAfficherAttributs(Boolean.TRUE);
                instanceCacherNom.remove(instance.getType() + " " + instance.getNom());
                break;
            }
        }
    }
