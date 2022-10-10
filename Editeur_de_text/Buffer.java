package TP2_bis;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Buffer {
    public int position;
    public int selectionD;
    public int selectionF;

    public JLabel zoneText;

    public List<String> saisie;

    public Buffer(JLabel text){
        zoneText = text;
        position = 0;
        selectionD = 0;
        selectionF = 0;
        saisie = new ArrayList<>();
    }

    public void update(){
        String memoire = "";
        for(int i=0;i<saisie.size();i++){
            memoire = memoire+saisie.get(i);
        }
        zoneText.setText(memoire);
    }

    public void add(String s){
        saisie.add(s);
    }
}
