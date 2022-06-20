package ch.eliaritzmann.graph_visualization.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

public class Map extends Observable {
    private Matrix matrix = new Matrix();
    private ArrayList<Point> points = new ArrayList<>();

    private boolean running = false;

    public void deleteKeyPressed(){
        if(!running){
            Point[] delete = getSelectedPoints();

            for (int i = 0; i < delete.length; i++) {
                //update matrix
                matrix.removePointFromMatrix(delete[i].getNumber());
            }

            points.removeIf(p -> p.isSeleted() != -1);


            for (int i = 0; i < points.size(); i++) {
                points.get(i).setNumber(i);
            }

            update();
        }

    }

    public void enterKeyPressed(){
        if(!running){
            if(getSelectedPoints().length == 2){
                System.out.println("enter");

                Point[] selectedPoints = getSelectedPoints();

                if(selectedPoints[0].isSeleted() > selectedPoints[1].isSeleted()){
                    matrix.addRelation(getSelectedPoints()[0], getSelectedPoints()[1]);
                }else{
                    matrix.addRelation(getSelectedPoints()[1], getSelectedPoints()[0]);
                }


                //Deselect points
                deSelectAll();
                update();
            }
        }
    }

    public void spaceKeyPressed(){
        if(getSelectedPoints().length == 2){
            running = true;

        }
    }

    public void mouseClicked(int x, int y){
        if(!running){
            addPoint(x, y);
        }

    }

    private Point[] getSelectedPoints(){
        ArrayList<Point> selectedPoints = new ArrayList<>();
        for (Point p: this.points
             ) {
            if (p.isSeleted() != -1){
                selectedPoints.add(p);
            }
        }

        Point[] array = new Point[selectedPoints.size()];
        return selectedPoints.toArray(array);
    }

    private void addPoint(int x, int y){
        if (points.size() == 0){
            points.add(new Point(x, y, 0));
            matrix.addPointToMatrix();
            update();
            return;
        }

        for (Point p: points
        ) {
            if(x > p.getX()-25 && x < p.getX()+25 && y > p.getY()-25 && y < p.getY()+25){
                //select Point
                if(p.isSeleted() != -1){
                    p.setSeleted(-1);
                }else{
                    if(getSelectedPoints().length == 2){
                        deSelectAll();
                    }else if(getSelectedPoints().length == 1){
                        p.setSeleted(1);
                    }else {
                        p.setSeleted(0);
                    }
                }

                update();
                return;

            }
        }

        points.add(new Point(x, y, points.size()));
        matrix.addPointToMatrix();
        update();
    }

    private void update(){
        matrix.debugMatrix();
        setChanged();
        notifyObservers(new Object[]{points, matrix.getRelations(points)});
    }

    private void deSelectAll(){
        for (Point p: points
             ) {p.setSeleted(-1);
        }
    }
}
