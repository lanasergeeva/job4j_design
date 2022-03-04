package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }


    /**
     * Пока строка меньше длины массива и колонка не равна  длине строки
     * увелчиваем строку, обнуляем колонку
     * @return строка меньше длины массива
     */
    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
        }
        return row < data.length;
    }

    /**
     * Пока hasNext возвращаем значение из массива. После - колонку увеличиваем на 1.
     * @return значение из массива
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
