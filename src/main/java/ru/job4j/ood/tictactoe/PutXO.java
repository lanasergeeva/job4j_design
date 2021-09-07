package ru.job4j.ood.tictactoe;

public class PutXO {
    private MatrixInterface matrix;
    private QueueInterface queueInterface;

    public void putX(int x, MatrixInterface matrix, QueueInterface playersQueue) {
        matrix.getMatrix()[x] = 1 == playersQueue.getPlayer() ? "X" : "O";
    }
}
