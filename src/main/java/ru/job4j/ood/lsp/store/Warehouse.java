package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Store {

    List<Food> warehouse = new LinkedList<>();

    @Override
    public void location(Food food, LocalDate today) {
        PercentExpireDate pr = new PercentExpireDate();
        double percent = pr.percentExpDate(food, today);
        if (percent < 25) {
            warehouse.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return warehouse;
    }

    @Override
    public void add(Food food) {
        if (!warehouse.contains(food)) {
            warehouse.add(food);
        }
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "warehouse=" + warehouse
                + '}';
    }
}
