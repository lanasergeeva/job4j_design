package ru.job4j.ood.tictactoe;

public class CreateMatrix {

    public void newPole(MatrixInterface matrix) {
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            matrix.getMatrix()[i] = Integer.toString(i + 1);
        }
    }
}
