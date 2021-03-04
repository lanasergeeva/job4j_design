package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int temp = 0;

    public SimpleArray(T[] array) {
        this.array = (T[]) new Object[50];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < temp;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[position++];
            }
        };
    }

    public boolean validate(int validate) {
        return validate >= 0 && validate < array.length;
    }


    public void add(T model) {
        array[temp] = model;
        temp++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, temp);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, temp);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        temp--;
    }

    public T get(int index) {
        Objects.checkIndex(index, temp);
        return array[index];
    }

    @Override
    public String toString() {
        return "SimpleArray{"
                + "array=" + Arrays.toString(array)
                + ", temp=" + temp
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleArray<?> that = (SimpleArray<?>) o;
        return temp == that.temp && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(temp);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}

