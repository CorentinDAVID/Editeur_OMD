package Editeur_de_text_v1;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Buffer {

    // Variable qui va servir à la position du curseur
    private int position;

    // Variable qui va servir à délimiter la borne supp de notre selection
    // (délimitée entre la position et la selection)
    private int selection;

    // Création d'un JLabel qui va recevoire le texte à afficher
    private JLabel zoneText;

    // Tableau qui va prendre les entrés de textes du clavier dans l'ordre
    private List<String> saisie;

    // Tableau qui va prendre la partie du tableau de saisie en fonction de la zone
    // de selection
    private List<String> sauvegarde;

    // Un booleen pour savoir si on est en mode selection ou non
    private Boolean etat;

    // Constructeur de Buffer
    public Buffer(JLabel text) {
        // Initialisation des attributs
        zoneText = text;
        position = -1;
        selection = 0;
        saisie = new ArrayList<>();
        sauvegarde = new ArrayList<>();
        etat = false;
    }

    /**
     * Fonction qui va mettre à jour le tableau de saisie avec les nouvelles entrées
     * du clavier, avant de les ajouter dans le JLabel
     */
    public void update() {
        // Le principe suivant est utile si on implemente un curseur visuel à notre
        // Editeur
        // Le but de ce curseur est de surligner en bleu le caractère ou on est
        // positionné actuellement

        // Dans ce if on vérifie dans quel mode on se trouve: si on est en mode
        // selection forcément l'attribut selection sera différent de la position, sinon
        // on actualise la selection avec la position
        if (!etat) {
            selection = position;
        }

        if (saisie.size() > 0) {
            // ici memoire1 représente la partie du texte entre le début et la position du
            // curseur
            String memoire1 = "";
            for (int i = 0; i < position; i++) {
                memoire1 = memoire1 + saisie.get(i);
            }

            // ici caseSelect représente le partie du texte dans la zone de selection (un
            // seul caractere si l'etat est a false)
            String caseSelect = "";
            for (int i = position; i <= selection; i++) {
                caseSelect = caseSelect + saisie.get(i);
            }

            // ici memoire2 represente le reste du texte
            String memoire2 = "";
            for (int i = selection + 1; i < saisie.size(); i++) {
                memoire2 = memoire2 + saisie.get(i);
            }

            // ici on ajoute le texte initialise precedemment en changeant la couleur pour
            // le curseur/la zone de selection
            zoneText.setText("<html><body><font color='black'>" + memoire1 + "<font color='blue'>" + caseSelect
                    + "<font color='black'>" + memoire2 + "</body></html>");
        } else {
            zoneText.setText("");
        }
    }

    /**
     * 
     * @param s La nouvelle entree du clavier
     * @param p La position du curseur
     * 
     *          Fonction qui ajoute la nouvelle entree dans la liste de saisie a la
     *          position du curseur
     */
    public void add(String s, int p) {
        if (saisie.size() > 0) {
            // On reset la memoire
            List<String> memoire = new ArrayList<>();

            // On ajoute tous les elements de la liste de saisie
            for (int i = 0; i < saisie.size(); i++) {
                memoire.add(saisie.get(i));
            }

            // reinitialise la saisie a 0
            saisie = new ArrayList<>();

            // ajoute a la saisie la partie en memoire du debut a la position du curseur
            for (int i = 0; i <= position; i++) {
                saisie.add(memoire.get(i));
            }

            // on rajoute la nouvelle entree du clavier
            saisie.add(s);

            // ajoute le reste de la memoire
            for (int i = position + 1; i < memoire.size(); i++) {
                saisie.add(memoire.get(i));
            }
        } else {
            saisie.add(s);
        }

        // incremente la position du curseur
        position++;
    }

    /**
     * Fonction qui supprime le caractere a la position du curseur
     */
    public void remove() {
        // supression du caractere a la position
        List<String> new_saisie = new ArrayList<>();
        for (int i = 0; i < saisie.size(); i++) {
            if (!(i >= position && i <= selection)) {
                new_saisie.add(saisie.get(i));
            }
        }
        saisie = new_saisie;
        // On decale le curseur vers la gauche si la saisie n'est pas vide
        if (position > -1) {
            position--;
        }
        selection = position;
    }

    /**
     * Fonction qui decale le curseur vers la droite si il ne depasse pas la taille
     * de la saisie
     */
    public void positionDroit() {
        if (position < saisie.size() - 1) {
            position++;
        }
    }

    /**
     * Fonction qui decale le curseur vers la droite si il n'est pas négatif
     */
    public void positionGauche() {
        if (position > 0) {
            position--;
        }
    }

    /**
     * Fonction qui incremente la position de la selection ce qui va etendre la zone
     * de selection
     */
    public void selectionDroit() {
        if (selection < saisie.size() - 1) {
            selection++;
        }
    }

    /**
     * Fonction qui decremente la position de la selection pour reduire la zone de
     * selection
     */
    public void selectionGauche() {
        if (selection > position) {
            selection--;
        }
    }

    /**
     * Getter de position
     * 
     * @return la position du curseur
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Setter de l'etat
     * 
     * @param b la valeur booleenne de l'etat
     */
    public void setEtat(Boolean b) {
        this.etat = b;
    }

    /**
     * Fonction qui va enregistrer la zone de selection dans la liste de String
     * sauvegarde
     */
    public void copier() {
        // Reinitialisation de la sauvegarde
        sauvegarde = new ArrayList<>();

        // ajoute tous les caracteres issus de la saisie dans la sauvegarde entre la
        // position du curseur et la fin de la zone de selection
        for (int i = position; i <= selection; i++) {
            sauvegarde.add(saisie.get(i));
        }
    }

    /**
     * Fonction qui va ajouter a la saisie la sauvegarde a la position du curseur
     */
    public void coller() {
        // On initialise la chaine d'ajout
        String ajout = "";

        // On recupere tous les caracteres de la sauvegarde qu'on concatene dans ajout
        for (int i = 0; i < sauvegarde.size(); i++) {
            ajout = ajout + sauvegarde.get(i);
        }

        // On utilise la fonction ajout avec le nouveau String et la position du curseur
        add(ajout, position);
    }

    public void couper() {
        // Reinitialisation de la sauvegarde
        sauvegarde = new ArrayList<>();

        // ajoute tous les caracteres issus de la saisie dans la sauvegarde entre la
        // position du curseur et la fin de la zone de selection
        for (int i = position; i <= selection; i++) {
            sauvegarde.add(saisie.get(i));
        }

        remove();
    }

}
