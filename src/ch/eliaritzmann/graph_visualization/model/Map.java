package ch.eliaritzmann.graph_visualization.model;

import java.util.ArrayList;
import java.util.Observable;

public class Map extends Observable {
    private ArrayList<Point> points = new ArrayList<>();
    private ArrayList<Realation> realations = new ArrayList<>();
    private int[][] matrix = new int[0][0];


    public void deleteKeyPressed(){

        Point[] delete = getSelectedPoints();

        for (int i = 0; i < delete.length; i++) {
            //update matrix
            System.out.println("Index: " + delete[i].getNumber());
            matrix = removePointFromMatrix(delete[i].getNumber());
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
            Realation realation = new Realation(getSelectedPoints()[0], getSelectedPoints()[1]);
            matrix[getSelectedPoints()[0].getNumber()][getSelectedPoints()[1].getNumber()] = (int)realation.getDistance();
            matrix[getSelectedPoints()[1].getNumber()][getSelectedPoints()[0].getNumber()] = (int)realation.getDistance();
            realations.add(realation);
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

    private int[][] addPointToMatrix(){
        int[][] matrix = new int[this.matrix.length+1][this.matrix.length+1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(j > this.matrix.length-1 || i > this.matrix.length-1){
                    //add new Points
                    matrix[i][j] = 0;
                }else{
                    //reuse Points
                    matrix[i][j] = this.matrix[i][j];
                }
            }
        }
        return matrix;
    }

    private int[][] removePointFromMatrix(int index){
        System.out.println(index);
        int[][] matrix = new int[this.matrix.length][this.matrix.length];
        System.out.println(this.matrix.length);
        for (int i = 0, ci = 0; i < this.matrix.length; i++) {
            for (int j = 0, cj = 0; j < this.matrix.length; j++) {
                if(i != index){
                    matrix[ci++][j] = this.matrix[i][j];
                }
            }
        }
        return matrix;
    }


    public void mouseClicked(int x, int y){
        addPoint(x, y);
    }

    private void addPoint(int x, int y){
        if (points.size() == 0){
            points.add(new Point(x, y, 0));
            matrix = addPointToMatrix();
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
        matrix = addPointToMatrix();
        update();
    }

    private void update(){
        debugMatrix();
        setChanged();
        notifyObservers(new Object[]{points, realations});
    }

    private void deSelectAll(){
        for (Point p: points
             ) {p.setSeleted(false);
        }
    }

    private void debugMatrix(){

        for (int i = 0; i<this.matrix.length; i++) {
            for (int j = 0; j<this.matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    System.out.print(0);
                }else{
                    System.out.print(matrix[i][j]);
                }

            }
            System.out.println();
        }
    }
}
