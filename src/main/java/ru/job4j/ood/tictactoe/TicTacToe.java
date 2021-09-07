package ru.job4j.ood.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        QueueInterface pq = new PlayersQueue();
        MatrixInterface matrix = new Matrix();
        Play play = new Play(matrix, pq);
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        MatMeth method = new MatrixMethod(matrix);
        LogicInterface logic = new LogicWin(method, pq, matrix);
        play.start(logic, input, output);
    }
}
