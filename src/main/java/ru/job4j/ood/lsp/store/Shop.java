package ru.job4j.ood.lsp.store;

import java.time.Duration;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Shop implements Store {
    List<Food> shopList = new LinkedList<>();

    @Override
    public void add(Food food) {
        shopList.add(food);
    }

    @Override
    public void location(Food food, LocalDate today) {
        PercentExpireDate pr = new PercentExpireDate();
        double percent = pr.percentExpDate(food, today);
        boolean lastDay = Duration.between(today.atStartOfDay(),
                food.getExpireDate().atStartOfDay()).toDays() == 1;
        if (percent > 25 && percent < 75 && !lastDay) {
            shopList.add(food);
        } else if ((percent >= 75 && percent < 100) || lastDay) {
            double newPrice = food.getPrice() * (food.getDiscount() / 100);
            food.setPrice(newPrice);
            shopList.add(food);
        }
    }

    @Override
    public List<Food> getList() {
        return shopList;
    }

    @Override
    public String toString() {
        return "Shop{"
                + "shopList=" + shopList
                + '}';
    }
}
