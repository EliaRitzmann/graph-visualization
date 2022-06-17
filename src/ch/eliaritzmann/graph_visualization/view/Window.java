package ch.eliaritzmann.graph_visualization.view;

import ch.eliaritzmann.graph_visualization.controller.Controller;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window {
    private Controller controller;
    private JFrame window = new JFrame();
    private Canvas canvas;

    private final int WINDOW_WIDTH_OFFSET = 18; //18
    private final int WINDOW_HEIGHT_OFFSET = 47; //47

    public Window(Controller controller, Canvas canvas) {
        this.controller = controller;
        this.canvas = canvas;
        window.setSize(500+WINDOW_WIDTH_OFFSET, 300+WINDOW_HEIGHT_OFFSET);
        window.setTitle("Graph visualization");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(canvas);
        window.setVisible(true);
        controller.setWindow(window);
    }

}
