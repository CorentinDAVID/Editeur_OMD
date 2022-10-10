package Editeur_de_text;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Interface extends JFrame implements ActionListener, KeyListener {

    public JFrame fenetre;
    public Buffer buffer;

    public JLabel text;

    public Boolean selection;

    public Interface() {
        fenetre = new JFrame();
        fenetre.addKeyListener(this);

        text = new JLabel();
        text.setVerticalAlignment(JLabel.TOP);
        text.setHorizontalAlignment(JLabel.LEFT);

        buffer = new Buffer(text);

        selection = false;

        fenetre.add(text);
        fenetre.setSize(600, 600);
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        if (arg0.getKeyCode() == 8) {
            buffer.remove();
        } else if (arg0.getKeyCode() == 16) {
            if (selection) {
                selection = false;
                System.out.println("Selection désactivée");
            } else {
                selection = true;
                System.out.println("Selection activée");
            }
        } else if (arg0.getKeyCode() == 39) {
            if (selection) {
                // buffer.selectionDroit();
            } else {
                buffer.positionDroit();
            }
        } else if (arg0.getKeyCode() == 37) {
            if (selection) {
                // buffer.selectionGauche();
            } else {
                buffer.positionGauche();
            }
        } else {
            buffer.add(String.valueOf(arg0.getKeyChar()));
        }
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
