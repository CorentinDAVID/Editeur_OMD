package Editeur_de_text_v1;

public class Coller implements Commandes {

    //Attribut
    public Buffer b;

    public Coller(Buffer b){
        //On recupere le Buffer courant
        this.b = b;
    }

    /**
     * Fonction qui va appeler la methode coller du Buffer courant
     */
    public void execute(){
        //appel de la methode coller
        b.coller();
    }
}
