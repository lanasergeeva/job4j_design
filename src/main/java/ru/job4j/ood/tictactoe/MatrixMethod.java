package ru.job4j.ood.tictactoe;

public class MatrixMethod implements MatMeth {

    private MatrixInterface matrix;

    public MatrixMethod(MatrixInterface matrix) {
        this.matrix = matrix;
    }

    public char getX(int x) {
        return matrix.getMatrix()[x].charAt(0);
    }

    public String getXY(int x, int y) {
        return matrix.getMatrix()[x * matrix.getSize() + y];
    }
}
