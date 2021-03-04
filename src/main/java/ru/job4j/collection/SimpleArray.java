package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int modCount = 0;
    private int capacity = 5;
    private int size = 0;
    private Object[] container;

    public SimpleArray() {
        this.container = new Object[capacity];
    }

    public T get(int index) {
        if (size == capacity) {
            capacity *= 2;
            container = Arrays.copyOf(container, capacity);
        }
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        container[size++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int position = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[position++];
            }
        };
    }
}
