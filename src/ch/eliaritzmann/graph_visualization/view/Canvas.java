package ch.eliaritzmann.graph_visualization.view;

import ch.eliaritzmann.graph_visualization.model.Point;
import ch.eliaritzmann.graph_visualization.model.Relation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * This Class draws the things on the Screen
 *
 *
 * @author  Elia Ritzmann
 * @version 1.0
 * @since   14.6.2022
 */
public class Canvas extends JComponent implements Observer {
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Relation> relations = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        //draw graphs (first)
        for (int i = 0; i < relations.size(); i++) {
            graphics2D.setColor(Color.black);
            graphics2D.drawLine(
                    relations.get(i).getPointa().getX() + 12,
                    relations.get(i).getPointa().getY() + 12,
                    relations.get(i).getPointb().getX() + 12,
                    relations.get(i).getPointb().getY() + 12
            );

            //Draw arrow
            double dy1 = relations.get(i).getPointa().getY()  - relations.get(i).getPointb().getY() ;
            double dx1 = relations.get(i).getPointa().getX()  - relations.get(i).getPointb().getX() ;
            double theta = Math.atan2(dy1, dx1);


            double x1, y1, rho = theta + Math.toRadians(40);
            for(int j = 0; j < 2; j++)
            {
                x1 = relations.get(i).getPointa().getX() + 12 - 20 * Math.cos(rho);
                y1 = relations.get(i).getPointa().getY() + 12 - 20 * Math.sin(rho);
                graphics2D.drawLine(relations.get(i).getPointa().getX() + 12, relations.get(i).getPointa().getY() + 12, (int )x1, (int)y1);
                rho = theta - Math.toRadians(40);
            }



            //draw number
            int dx = Math.abs(relations.get(i).getPointb().getX()- relations.get(i).getPointa().getX());
            int dy = Math.abs(relations.get(i).getPointb().getY()- relations.get(i).getPointa().getY());

            int x;
            int y;

            if(relations.get(i).getPointb().getX() > relations.get(i).getPointa().getX()){
                x = relations.get(i).getPointa().getX() + dx/2 + 16;
            }else{
                x = relations.get(i).getPointa().getX() - dx/2 + 16;
            }

            if(relations.get(i).getPointb().getY() > relations.get(i).getPointa().getY()){
                y = relations.get(i).getPointa().getY() + dy/2 + 5;
            }else{
                y = relations.get(i).getPointa().getY() - dy/2 + 5;
            }

            graphics2D.drawString("" + (int) relations.get(i).getDistance(), x, y);

        }

        //draw points (on top of graphs)
        for (int i = 0; i < points.size(); i++) {
            graphics2D.setColor(Color.black);
            if(points.get(i).isSeleted() != -1){
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
        relations = (ArrayList<Relation>) objects[1];
        repaint();
    }
}
