package ru.job4j.ood.tictactoe;

public interface LogicInterface {
    boolean isGameEnd();
    boolean checkAllMatrix();
    boolean checkDiagonals();
    boolean checksPossible();

}
