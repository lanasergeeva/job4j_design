package ru.job4j.ood.tictactoe;

public class ShowMatrix {
    private MatrixInterface matrix;

    public ShowMatrix(MatrixInterface matrix) {
        this.matrix = matrix;
    }

    public void showMatrix() {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                System.out.printf("%4s", matrix.getMatrix()[i * matrix.getSize() + j]);
            }
            System.out.print("\n");
        }
    }
}
