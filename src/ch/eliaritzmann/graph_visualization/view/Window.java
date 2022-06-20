package ch.eliaritzmann.graph_visualization.view;

import ch.eliaritzmann.graph_visualization.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This Class contains the logic for the window.
 *
 *
 * @author  Elia Ritzmann
 * @version 1.0
 * @since   14.6.2022
 */
public class Window {
    private Controller controller;
    private JFrame window = new JFrame();
    private Canvas canvas;

    private final int WINDOW_WIDTH_OFFSET = 18; //18
    private final int WINDOW_HEIGHT_OFFSET = 47; //47

    public Window(Controller controller, Canvas canvas) {
        this.controller = controller;
        this.canvas = canvas;

        ImageIcon imageIcon = new ImageIcon("images/icon.png");

        window.setIconImage(imageIcon.getImage());
        window.setSize(500+WINDOW_WIDTH_OFFSET, 300+WINDOW_HEIGHT_OFFSET);
        window.setTitle("Graph visualization");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas);
        window.setVisible(true);
        controller.setWindow(window);
    }
}
