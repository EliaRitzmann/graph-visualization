package ch.eliaritzmann.graph_visualization.model;


/**
 * This Class contains the logic for the points.
 *
 *
 * @author  Elia Ritzmann
 * @version 1.0
 * @since   14.6.2022
 */
public class Point {
    private int x;
    private int y;
    private int number;
    private int isSelected = -1;

    public void setNumber(int number) {
        this.number = number;
    }

    public Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public int isSeleted() {
        return isSelected;
    }

    public void setSeleted(int seleted) {
        isSelected = seleted;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }
}
