package ch.eliaritzmann.graph_visualization.model;

import java.util.ArrayList;

public class Matrix {
    private int[][] matrix = new int[0][0];

    public void addRelation(Point a, Point b){
        Relation relation = new Relation(a, b);


        matrix[a.getNumber()][b.getNumber()] = (int) relation.getDistance();
    }

    public void addPointToMatrix(){
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
        this.matrix = matrix;
    }

    public void removePointFromMatrix(int index){
        int[][] matrix = new int[this.matrix.length-1][this.matrix.length-1];

        for (int i = 0, ci = 0; i < matrix.length; i++) {
            if (i != index){
                for (int j = 0, cj = 0; j < matrix[i].length; j++) {
                    if(j != index){
                        matrix[ci][cj] = this.matrix[i][j];
                        cj++;
                    }
                }
                ci++;
            }

        }
        this.matrix = matrix;
    }

    public ArrayList<Relation> getRelations(ArrayList<Point> points){
        ArrayList<Relation> relations = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 0){
                    relations.add(new Relation(points.get(i), points.get(j)));
                }
            }
        }
        return relations;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void debugMatrix(){

        for (int i = 0; i<this.matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j<this.matrix[i].length; j++) {

                if(matrix[i][j] == 0){
                    System.out.print(0);
                }else{
                    System.out.print(matrix[i][j]);
                }
                System.out.print("|");

            }
            System.out.println();
        }
        System.out.println("xxxxxxxxxxx");
    }
}
