package Editeur_de_text;

public class Coller implements Commandes {

    public Buffer b;

    public Coller(Buffer b){
        this.b = b;
    }

    public void execute(){
        b.coller();
    }
}
