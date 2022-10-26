package Editeur_de_text_v2;

public class Save implements Commandes {

    // Attribut
    private Buffer b;

    public Save(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va appeler la methode coller du Buffer courant
     */
    public void execute() {
        // appel de la methode coller
        b.save();
    }
}
