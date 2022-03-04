package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public /*class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
    }

    *//**
     * Сравниваем point с длинной массива.
     * @return булевое значени
     *//*
    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    *//**
     * Пока hasNext true возвращаем значения из массива.
     * Вычисляем из длины 1 и значения point, которое увеличиваем на 1 каждое сравнение
     * @return
     *//*
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[data.length - 1 - point++];
    }
}*/

class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.point = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return point >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point--];
    }
}

