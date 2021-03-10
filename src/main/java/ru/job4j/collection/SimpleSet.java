package ru.job4j.collection;


import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> simpleArray = new SimpleArray<>();

    public void add(T model) {
        if (check(model)) {
            simpleArray.add(model);
        }
    }

    public boolean check(T model) {
        boolean rsl = true;
        for (Object ob : simpleArray) {
            if (Objects.equals(model, ob)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }


    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleSet<?> simpleSet = (SimpleSet<?>) o;
        return Objects.equals(simpleArray, simpleSet.simpleArray);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simpleArray);
    }
}
