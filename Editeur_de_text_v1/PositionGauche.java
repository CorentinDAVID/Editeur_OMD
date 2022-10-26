package Editeur_de_text_v1;

public class PositionGauche implements Commandes {

    // Attribut
    private Buffer b;

    public PositionGauche(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va executer la methode positionGauche du buffer courant
     */
    public void execute() {
        // appel de la methode positionGauche
        b.positionGauche();
    }
}
