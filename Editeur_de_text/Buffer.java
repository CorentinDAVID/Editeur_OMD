package Editeur_de_text;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Buffer {
    public int position;
    public int selection;

    public JLabel zoneText;

    public List<String> saisie;

    public Boolean etat;

    public Buffer(JLabel text) {
        zoneText = text;
        position = -1;
        selection = 0;
        saisie = new ArrayList<>();
        etat = false;
    }

    public void update() {
        String memoire1 = "";
        for (int i = 0; i < position; i++) {
            memoire1 = memoire1 + saisie.get(i);
        }
        String caseSelect = "";
        if(position > 0){
            caseSelect = saisie.get(position);
        }
        String memoire2 = "";
        for(int i=position+1;i<saisie.size();i++){
            memoire2 = memoire2 + saisie.get(i);
        }
        zoneText.setText("<html><body><font color='black'>"+memoire1+"<font color='blue'>"+caseSelect+"<font color='black'>"+memoire2+"</body></html>");
        if(!etat){
            selection = position;
        }
        System.out.println(selection);
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
        saisie.remove(saisie.size() - 1);
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

}
