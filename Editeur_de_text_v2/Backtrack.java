package Editeur_de_text_v2;

public class Backtrack implements Commandes {

    // Attribut
    private Buffer b;

    public Backtrack(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va appeler la methode coller du Buffer courant
     */
    public void execute() {
        // appel de la methode coller
        b.backtrack();
    }
}
