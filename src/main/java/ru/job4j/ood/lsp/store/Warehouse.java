package ru.job4j.ood.lsp.store;

import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Store {

    private final List<Food> warehouse = new LinkedList<>();

    @Override
    public boolean accept(Food food) {
        double percent = percentExpDate(food);
        return percent < 25;
    }

    @Override
    public List<Food> getList() {
        return new LinkedList<>(warehouse);
    }

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            warehouse.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public void clear() {
        warehouse.clear();
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "warehouse=" + warehouse
                + '}';
    }
}
