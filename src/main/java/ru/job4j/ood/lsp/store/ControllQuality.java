package ru.job4j.ood.lsp.store;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ControllQuality {
    private List<Store> storeList;

    public ControllQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void executeStore(Food food, LocalDate today) {
        for (Store store : storeList) {
            store.location(food, today);
        }
    }

    public void resort(LocalDate today) {
        List<Food> all = new LinkedList<>();
        for (Store store : storeList) {
            all.addAll(store.getList());
            store.getList().clear();
        }
        for (Food food : all) {
            executeStore(food, today);
        }
    }


    public static void main(String[] args) {
        Food water = new Food("Вода газ", LocalDate.of(2021, 8, 20),
                LocalDate.of(2021, 8, 10), 156.98, 10);
        Food cheese = new Food("Сыр", LocalDate.of(2021, 8, 16),
                LocalDate.of(2021, 8, 14), 150, 30);
        Food milk = new Food("Молоко", LocalDate.of(2021, 8, 15),
                LocalDate.of(2021, 8, 10), 80, 40);
        Food sauce = new Food("Хайнс", LocalDate.of(2021, 6, 24),
                LocalDate.of(2021, 10, 12), 88.99, 10);
        Food chocolate = new Food("Шоколад", LocalDate.of(2021, 8, 24),
                LocalDate.of(2021, 8, 14), 88.99, 10);
        List<Food> foodList = List.of(water, cheese, milk, sauce, chocolate);
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        List<Store> stores = List.of(warehouse, trash, shop);
        ControllQuality cq = new ControllQuality(stores);
        for (Food food : foodList) {
            cq.executeStore(food, LocalDate.of(2021, 8, 15));
        }
        System.out.println(stores);
        cq.resort(LocalDate.of(2021, 8, 16));
        System.out.println(stores);
    }
}
