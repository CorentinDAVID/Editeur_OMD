package Editeur_de_text_v2;

public class Remove implements Commandes {

    // Attribut
    private Buffer b;

    public Remove(Buffer b) {
        // On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va executer la methode remove du buffer courant
     */
    public void execute() {
        // appel de la methode remove
        b.remove();
    }
}
