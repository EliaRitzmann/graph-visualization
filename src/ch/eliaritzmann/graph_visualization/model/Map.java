package ch.eliaritzmann.graph_visualization.model;

import java.util.ArrayList;
import java.util.Observable;

public class Map extends Observable {
    private Matrix matrix = new Matrix();
    private ArrayList<Point> points = new ArrayList<>();

    public void deleteKeyPressed(){

        Point[] delete = getSelectedPoints();

        for (int i = 0; i < delete.length; i++) {
            //update matrix
            System.out.println("Index: " + delete[i].getNumber());
            matrix.removePointFromMatrix(delete[i].getNumber());
        }

        points.removeIf(Point::isSeleted);

        for (int i = 0; i < points.size(); i++) {
            points.get(i).setNumber(i);
        }

        update();
    }

    public void enterKeyPressed(){
        if(getSelectedPoints().length == 2){
            System.out.println("enter");
            matrix.addRelation(getSelectedPoints()[0], getSelectedPoints()[1]);

            //Deselect points
            deSelectAll();
            update();
        }

    }

    private Point[] getSelectedPoints(){
        ArrayList<Point> selectedPoints = new ArrayList<>();
        for (Point p: this.points
             ) {
            if (p.isSeleted()){
                selectedPoints.add(p);
            }
        }

        Point[] array = new Point[selectedPoints.size()];
        return selectedPoints.toArray(array);
    }

    public void mouseClicked(int x, int y){
        addPoint(x, y);
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
                if(getSelectedPoints().length == 2){
                    deSelectAll();
                }else{
                    p.setSeleted(!p.isSeleted());
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
             ) {p.setSeleted(false);
        }
    }
}
