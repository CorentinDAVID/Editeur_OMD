package TP2_bis;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Interface extends JFrame implements ActionListener, KeyListener{
    
    public JFrame fenetre;
    public Buffer buffer;

    public JLabel text;

    public Interface(){
        fenetre = new JFrame();
        fenetre.addKeyListener(this);

        text = new JLabel();
        text.setVerticalAlignment(JLabel.TOP);
        text.setHorizontalAlignment(JLabel.LEFT);

        buffer = new Buffer(text);


        fenetre.add(text);
        fenetre.setSize(600, 600);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

        buffer.update();
    }


    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        buffer.add(String.valueOf(arg0.getKeyChar()));
        buffer.update();
    }


    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
