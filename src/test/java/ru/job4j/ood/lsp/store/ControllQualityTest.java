package ru.job4j.ood.lsp.store;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void whileExecuteTrashShop() {
        Food water = new Food("Вода газ", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(10), 156.98, 10);
        Food cheese = new Food("Сыр", LocalDate.now(),
                LocalDate.now().minusDays(1), 150, 30);
        Food sauce = new Food("Соус горчичный", LocalDate.now().plusDays(180),
                LocalDate.now(), 150, 30);
        Shop shop = new Shop();
        Trash trash = new Trash();
        Warehouse warehouse = new Warehouse();
        List<Store> stores = List.of(trash, shop, warehouse);
        ControllQuality cq = new ControllQuality(stores);
        cq.executeStore(water);
        cq.executeStore(cheese);
        cq.executeStore(sauce);
        assertThat(shop.getList().size(), is(1));
        assertThat(trash.getList().size(), is(1));
        assertThat(warehouse.getList().size(), is(1));
    }

    @Test
    public void whileDiscountFood() {
        Food water = new Food("Вода газ", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(10), 156.98, 10);
        Food cheese = new Food("Сыр", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(7), 150, 30);
        Shop shop = new Shop();
        List<Store> stores = List.of(shop);
        ControllQuality cq = new ControllQuality(stores);
        double priceWater = water.getPrice() * (water.getDiscount() / 100);
        double priceCheese = cheese.getPrice() * (cheese.getDiscount() / 100);
        cq.executeStore(cheese);
        cq.executeStore(water);
        assertThat(shop.getList().size(), is(2));
        assertThat(water.getPrice(), is(priceWater));
        assertThat(cheese.getPrice(), is(priceCheese));
    }

    @Test
    public void whileTrash() {
        Food water = new Food("Вода газ", LocalDate.now(),
                LocalDate.now().minusDays(10), 156.98, 10);
        Trash trash = new Trash();
        Shop shop = new Shop();
        List<Store> stores = List.of(trash, shop);
        ControllQuality cq = new ControllQuality(stores);
        cq.executeStore(water);
        assertThat(trash.getList().size(), is(1));
    }
}
