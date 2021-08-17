package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


public class Trash implements Store {
    List<Food> trash = new LinkedList<>();

    @Override
    public void add(Food food) {
        trash.add(food);
    }

    @Override
    public void location(Food food, LocalDate today) {
        PercentExpireDate pr = new PercentExpireDate();
        double percent = pr.percentExpDate(food, today);
        if (percent >= 100) {
            trash.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return trash;
    }

    @Override
    public String toString() {
        return "Trash{"
                + "trash=" + trash
                + '}';
    }
}
