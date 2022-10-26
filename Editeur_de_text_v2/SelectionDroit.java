package Editeur_de_text_v2;

public class SelectionDroit implements Commandes {

    // Attribut
    private Buffer b;

    public SelectionDroit(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va executer la methode selectionDroit du buffer courant
     */
    public void execute() {
        // appel de la methode selectionDroit
        b.selectionDroit();
    }
}
