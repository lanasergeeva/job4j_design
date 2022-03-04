package ru.job4j.ood.lsp.store;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface Store {

    boolean add(Food food);

    boolean accept(Food food);

    List<Food> getList();

    void clear();

    default double percentExpDate(Food food) {
        double rsl = 0.0;
        LocalDate now = LocalDate.now();
        double allDays = (double) Duration.between(food.getCreateDate().atStartOfDay(),
                food.getExpireDate().atStartOfDay()).toDays();
        double useDays = (double) Duration.between(food.getCreateDate().atStartOfDay(),
                now.atStartOfDay()).toDays();
        if (food.getCreateDate().equals(now) || now.isBefore(food.getCreateDate())) {
            rsl = 1;
        } else if (food.getExpireDate().equals(now) || now.isAfter(food.getExpireDate())) {
            rsl = 100;
        } else if (now.isAfter(food.getCreateDate()) && now.isBefore(food.getExpireDate())) {
            rsl = useDays / allDays * 100;
        }
        return rsl;
    }
}
