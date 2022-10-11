package Editeur_de_text;

public class Copier implements Commandes {

    public Buffer b;

    public Copier(Buffer b){
        this.b = b;
    }

    public void execute(){
        b.copier();
    }
}
