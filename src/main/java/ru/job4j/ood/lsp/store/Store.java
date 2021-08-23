package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.List;

public interface Store {

    void add(Food food);

    void location(Food food, LocalDate today);

    List<Food> getList();
}
