package ch.eliaritzmann.graph_visualization.view;

import ch.eliaritzmann.graph_visualization.model.Point;
import ch.eliaritzmann.graph_visualization.model.Realation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Canvas extends JComponent implements Observer {
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Realation> realations = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        for (int i = 0; i < points.size(); i++) {
            graphics2D.setColor(Color.black);
            if(points.get(i).isSeleted()){
                graphics2D.setColor(Color.blue);
            }
            graphics2D.fillOval(points.get(i).getX(), points.get(i).getY(), 25, 25);


            graphics2D.setColor(Color.white);
            if(points.get(i).getNumber() > 9){
                graphics2D.drawString(Integer.toString(points.get(i).getNumber()) , points.get(i).getX()+7, points.get(i).getY()+16);
            }else{
                graphics2D.drawString(Integer.toString(points.get(i).getNumber()) , points.get(i).getX()+9, points.get(i).getY()+16);
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Object[] objects = (Object[]) arg;
        points = (ArrayList<Point>) objects[0];
        realations = (ArrayList<Realation>) objects[1];
        repaint();
    }
}
