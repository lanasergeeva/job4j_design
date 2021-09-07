package ru.job4j.ood.tictactoe;

public class Matrix implements MatrixInterface {

    private final int size = 3;
    private final String[] array;

    public Matrix() {
        array = new String[size * size];
    }

    public String[] getArray() {
        return array;
    }

    @Override
    public String[] getMatrix() {
        return array;
    }

    @Override
    public String getByIndex(int index) {
        return array[index];
    }

    @Override
    public int getSize() {
        return size;
    }

}
