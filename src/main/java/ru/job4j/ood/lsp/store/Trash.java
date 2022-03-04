package ru.job4j.ood.lsp.store;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Trash implements Store {
    private final List<Food> trash = new LinkedList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            trash.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        double percent = percentExpDate(food);
        return percent >= 100;
    }

    @Override
    public List<Food> getList() {
        return new LinkedList<>(trash);
    }

    @Override
    public void clear() {
        trash.clear();
    }

    @Override
    public String toString() {
        return "Trash{"
                + "trash=" + trash
                + '}';
    }
}
