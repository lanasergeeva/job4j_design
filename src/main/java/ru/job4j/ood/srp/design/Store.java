package ru.job4j.ood.srp.design;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
