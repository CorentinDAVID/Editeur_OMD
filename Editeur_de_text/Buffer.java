package Editeur_de_text;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Buffer {

    //Variable qui va servir à la position du curseur
    public int position;

    //Variable qui va servir à délimiter la borne supp de notre selection (délimitée entre la position et la selection)
    public int selection;

    //Création d'un JLabel qui va recevoire le texte à afficher
    public JLabel zoneText;

    //Tableau qui va prendre les entrés de textes du clavier dans l'ordre
    public List<String> saisie;

    //Tableau qui va prendre la partie du tableau de saisie en fonction de la zone de selection
    public List<String> sauvegarde;

    //Un booleen pour savoir si on est en mode selection ou non
    public Boolean etat;

    //Constructeur de Buffer
    public Buffer(JLabel text) {
        //Initialisation des attributs
        zoneText = text;
        position = -1;
        selection = 0;
        saisie = new ArrayList<>();
        sauvegarde = new ArrayList<>();
        etat = false;
    }

    /**
     * Fonction qui va mettre à jour le tableau de saisie avec les nouvelles entrées du clavier, avant de les ajouter dans le JLabel
     */
    public void update() {
        //Le principe suivant est utile si on implemente un curseur visuel à notre Editeur
        //Le but de ce curseur est de surligner en bleu le caractère ou on est positionné actuellement
        
        //Dans ce if on vérifie dans quel mode on se trouve: si on est en mode selection forcément l'attribut selection sera différent de la position, sinon on actualise la selection avec la position
        if(!etat){
            selection = position;
        }

        //ici memoire1 représente la partie du texte entre le début et la position du curseur
        String memoire1 = "";
        for (int i = 0; i < position; i++) {
            memoire1 = memoire1 + saisie.get(i);
        }

        //ici caseSelect représente le partie du texte dans la zone de selection (un seul caractere si l'etat est a false)
        String caseSelect = "";
        for(int i=position;i<=selection;i++){
            caseSelect = caseSelect + saisie.get(i);
        }

        //ici memoire2 represente le reste du texte
        String memoire2 = "";
        for(int i=selection+1;i<saisie.size();i++){
            memoire2 = memoire2 + saisie.get(i);
        }

        //ici on ajoute le texte initialise precedemment en changeant la couleur pour le curseur/la zone de selection
        zoneText.setText("<html><body><font color='black'>"+memoire1+"<font color='blue'>"+caseSelect+"<font color='black'>"+memoire2+"</body></html>");
    }

    public void add(String s,int p) {
        List<String> memoire = new ArrayList<>();
        for(int i=0;i<saisie.size();i++){
            memoire.add(saisie.get(i));
        }

        saisie = new ArrayList<>();
        for(int i=0;i<=position;i++){
            saisie.add(memoire.get(i));
        }
        saisie.add(s);
        for(int i=position+1;i<memoire.size();i++){
            saisie.add(memoire.get(i));
        }
        position++;
    }

    public void remove() {
        saisie.remove(position);
        if (position > 0) {
            position--;
        }
    }

    public void positionDroit() {
        if(position < saisie.size()-1){
            position++;
        }
    }

    public void positionGauche() {
        if (position > 0) {
            position--;
        }
    }

    public void selectionDroit(){
        if(selection < saisie.size()-1){
            selection++;
        }
    }

    public void selectionGauche(){
        if(selection > position){
            selection--;
        }
    }

    public int getPosition(){
        return this.position;
    }

    public void setEtat(Boolean b){
        this.etat = b;
    }

    public void copier(){
        sauvegarde = new ArrayList<>();
        for(int i=position;i<=selection;i++){
            sauvegarde.add(saisie.get(i));
        }
    }

    public void coller(){
        String ajout ="";
        for(int i=0;i<sauvegarde.size();i++){
            ajout = ajout + sauvegarde.get(i);
        }
        add(ajout,position);
    }

}
