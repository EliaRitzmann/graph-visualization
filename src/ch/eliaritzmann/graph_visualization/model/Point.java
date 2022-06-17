package ch.eliaritzmann.graph_visualization.model;

public class Point {
    private int x;
    private int y;
    private int number;
    private boolean isSeleted = false;

    public void setNumber(int number) {
        this.number = number;
    }

    public Point(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public boolean isSeleted() {
        return isSeleted;
    }

    public void setSeleted(boolean seleted) {
        isSeleted = seleted;
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
