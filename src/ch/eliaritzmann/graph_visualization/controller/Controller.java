package ch.eliaritzmann.graph_visualization.controller;

import ch.eliaritzmann.graph_visualization.model.Map;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
        * This Class handles the User inputs.
        *
        *
        * @author  Elia Ritzmann
        * @version 1.0
        * @since   14.6.2022
        */
public class Controller implements MouseListener, KeyListener {
    private JFrame window;
    private final Map map;

    public Controller(Map map) {
        this.map = map;
    }

    //function will run at the start of the Program
    public void run() {
        window.addMouseListener(this);
        window.addKeyListener(this);
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        map.mouseClicked(e.getX()-18, e.getY()-47);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DELETE){
            map.deleteKeyPressed();
        }else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            map.enterKeyPressed();
        }else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            map.spaceKeyPressed();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
