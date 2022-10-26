package Editeur_de_text_v1;

public class Couper implements Commandes {

    // Attribut
    private Buffer b;

    public Couper(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va appeler la methode couper du Buffer courant
     */
    public void execute() {
        // appel de la methode couper
        b.couper();
    }
}
