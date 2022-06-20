package ch.eliaritzmann.graph_visualization.model;


/**
 * This Class contains the logic for the relations.
 *
 *
 * @author  Elia Ritzmann
 * @version 1.0
 * @since   14.6.2022
 */
public class Relation {
    private Point pointa;
    private Point pointb;

    public Point getPointa() {
        return pointa;
    }

    public Point getPointb() {
        return pointb;
    }

    public Relation(Point pointa, Point pointb) {
        this.pointa = pointa;
        this.pointb = pointb;
    }

    //returns the distance in pixel between the two points
    public double getDistance(){
        //Pythagoras
        int a = pointa.getX() - pointb.getX();
        int b = pointa.getY() - pointb.getY();

        return Math.sqrt(Math.pow(Math.abs(a), 2) + Math.pow(Math.abs(b), 2));
    }
}
