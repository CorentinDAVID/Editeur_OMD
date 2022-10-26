package Editeur_de_text_v1;

public class PositionDroit implements Commandes {

    // Attribut
    private Buffer b;

    public PositionDroit(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va executer la methode positionDroit du buffer courant
     */
    public void execute() {
        // appel de la methode positionDroit
        b.positionDroit();
    }
}
