package Editeur_de_text_v1;

public class SelectionGauche implements Commandes {

    // Attribut
    private Buffer b;

    public SelectionGauche(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va executer la methode selectionGauche du buffer courant
     */
    public void execute() {
        // appel de la methode selectionGauche
        b.selectionGauche();
    }
}
