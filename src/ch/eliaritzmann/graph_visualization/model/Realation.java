package ch.eliaritzmann.graph_visualization.model;

public class Realation {
    private Point pointa;
    private Point pointb;

    public Point getPointa() {
        return pointa;
    }

    public Point getPointb() {
        return pointb;
    }

    public Realation(Point pointa, Point pointb) {
        this.pointa = pointa;
        this.pointb = pointb;
    }

    public double getDistance(){
        //Pythagoras
        int a = pointa.getX() - pointb.getX();
        int b = pointa.getY() - pointb.getY();

        return Math.sqrt(Math.pow(Math.abs(a), 2) + Math.pow(Math.abs(b), 2));
    }
}
