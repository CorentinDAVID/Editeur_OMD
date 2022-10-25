package Editeur_de_text_v2;

public class Copier implements Commandes {

    // Attribut
    private Buffer b;

    public Copier(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va executer la methode copier du buffer courant
     */
    public void execute() {
        // appel de la methode copier
        b.copier();
    }
}
