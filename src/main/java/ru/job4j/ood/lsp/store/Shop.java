package ru.job4j.ood.lsp.store;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> shopList = new LinkedList<>();

    @Override
    public boolean add(Food food) {
        boolean rsl = false;
        double percent = percentExpDate(food);
        boolean lastDay = Duration.between(LocalDate.now().atStartOfDay(),
                food.getExpireDate().atStartOfDay()).toDays() == 1;
        if (accept(food)) {
            if ((percent >= 75 && percent < 100) || lastDay) {
                double newPrice = food.getPrice() * (food.getDiscount() / 100);
                food.setPrice(newPrice);
            }
            shopList.add(food);
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        double percent = percentExpDate(food);
        boolean lastDay = Duration.between(LocalDate.now().atStartOfDay(),
                food.getExpireDate().atStartOfDay()).toDays() == 1;
        if (percent > 25 && percent < 100 && !lastDay) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getList() {
        return new ArrayList<>(shopList);
    }

    @Override
    public void clear() {
        shopList.clear();
    }

    @Override
    public String toString() {
        return "Shop{"
                + "shopList=" + shopList
                + '}';
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        Food water = new Food("Вода газ", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(10), 156.98, 10);
        Food cheese = new Food("Сыр", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(3), 150, 30);
        System.out.println(shop.percentExpDate(water));
        System.out.println(shop.percentExpDate(cheese));
    }
}
