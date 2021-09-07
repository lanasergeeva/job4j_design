package ru.job4j.ood.tictactoe;

public class ValidateInput implements Input {

    private final Output out;
    private final Input in;
    private MatrixInterface matrix;

    public ValidateInput(Output out, Input in, MatrixInterface matrix) {
        this.out = out;
        this.in = in;
        this.matrix = matrix;
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            value = in.askInt(question) - 1;
            invalid = false;
            if (value >= matrix.getMatrix().length || value < 0
                    || matrix.getByIndex(value).startsWith("X")
                    || matrix.getByIndex(value).startsWith("O")) {
                invalid = true;
                out.println("Вы ввели неправильное число. Повторите ввод");
            }
        } while (invalid);
        return value;
    }
}
