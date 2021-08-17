package ru.job4j.ood.lsp.store;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whileExecuteTrashShop() {
        Food water = new Food("Вода газ", LocalDate.of(2021, 8, 15),
                LocalDate.of(2021, 8, 2), 156.98, 10);
        Food cheese = new Food("Сыр", LocalDate.of(2021, 8, 13),
                LocalDate.of(2021, 8, 11), 150, 30);
        List<Food> foodList = List.of(water, cheese);
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = List.of(trash, shop);
        ControllQuality cq = new ControllQuality(stores);
        for (Food food : foodList) {
            cq.executeStore(food, LocalDate.of(2021, 8, 14));
        }
        Shop rsl = new Shop();
        rsl.add(water);
        assertThat(shop.getList(), is(rsl.getList()));
    }

    @Test
    public void whileDiscountFood() {
        Food cheese = new Food("Сыр", LocalDate.of(2021, 8, 15),
                LocalDate.of(2021, 8, 11), 150, 30);
        Food rsl = new Food("Сыр", LocalDate.of(2021, 8, 15),
                LocalDate.of(2021, 8, 11), 150, 30);
        Shop shop = new Shop();
        List<Store> stores = List.of(shop);
        ControllQuality cq = new ControllQuality(stores);
        cq.executeStore(cheese, LocalDate.of(2021, 8, 14));
        rsl.setPrice(rsl.getPrice() * (rsl.getDiscount() / 100));
        assertThat(cheese.getPrice(), is(rsl.getPrice()));
    }

    @Test
    public void whileTrash() {
        Food water = new Food("Вода газ", LocalDate.of(2021, 8, 19),
                LocalDate.of(2021, 8, 10), 156.98, 10);
        Trash trash = new Trash();
        Shop shop = new Shop();
        List<Store> stores = List.of(trash, shop);
        ControllQuality cq = new ControllQuality(stores);
        cq.executeStore(water, LocalDate.of(2021, 8, 20));
        String name = trash.getList().get(0).getName();
        assertEquals("Вода газ", name);
    }
}