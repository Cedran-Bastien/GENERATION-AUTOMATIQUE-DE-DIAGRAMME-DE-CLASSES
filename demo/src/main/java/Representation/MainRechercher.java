package Representation;

import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.EventListener;

public class MainRechercher implements EventListener {
    /**
     * Methode permettant au programme de recourir à l'explorateur de fichier Windows
     * puis on recupere le chemin du projet.
     */
    public static void RechercherRepertoire() throws IOException {

        FileChooser chooser = new FileChooser();
        chooser.showOpenDialog(null);

        //Runtime.getRuntime().exec("explorer.exe");

    }

    public static void main(String[] args) throws IOException {

    }
}
