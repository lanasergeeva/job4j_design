package ru.job4j.kiss;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    static <T> T findBy(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = null;
        for (int i = 0; i < value.size() - 1; i++) {
            T first = value.get(i);
            int comp = comparator.compare(first, value.get(i + 1));
            if (predicate.test(comp)) {
                rsl = value.get(i + 1);
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

