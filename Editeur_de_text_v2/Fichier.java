package Editeur_de_text_v2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Fichier {

    // Le contenu de la saisie à sauvegarder
    private String contenu;

    public Fichier(String contenu) {
        this.contenu = contenu;

        // On crée le fichier sauvegarde.txt puis on y enregistre le contenu
        Path path = Paths.get("./sauvegarde.txt");
        try {
            byte[] bs = contenu.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println("La saisie a été sauvegardée dans le fichier sauvegarde.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
