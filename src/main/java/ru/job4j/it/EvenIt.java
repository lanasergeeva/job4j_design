package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] numbers;
    private int point = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    /**
     * Пока point меньше длины массива и число нечетное, увелчиваем point
     * @return point меньше длины массива
     */
    @Override
    public boolean hasNext() {
        while (point < numbers.length && numbers[point] % 2 != 0) {
            point++;
        }
        return point < numbers.length;
    }

    /**
     * Здесь будут выводится только четные числа, так как нечетые проитерируются в while
     * в hasNext
     * @return четное значени
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[point++];
    }

}
