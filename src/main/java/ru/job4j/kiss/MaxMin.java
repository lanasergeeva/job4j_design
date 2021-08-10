package ru.job4j.kiss;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    static <T> T findBy(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (T t : value) {
            int comp = comparator.compare(rsl, t);
            if (predicate.test(comp)) {
                rsl = t;
            }
        }
        return rsl;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, predicate -> predicate < 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findBy(value, comparator, predicate -> predicate > 0);
    }

}

