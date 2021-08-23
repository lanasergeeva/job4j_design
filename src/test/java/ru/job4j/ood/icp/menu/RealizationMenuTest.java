package ru.job4j.ood.icp.menu;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RealizationMenuTest {
    @Test
    public void whenSelect() {
        RealizationMenu rz = new RealizationMenu();
        Menu two = new Menu("Задача 2");
        Menu oneone = new Menu("Задача 1.1",
                List.of(new Menu("Задача 1.1.1"),
                        new Menu("Задача 1.1.2")));

        rz.show(new Menu("Menu", List.of(new Menu("Задача 1",
                List.of(oneone,
                        new Menu("Задача 1.2", List.of(new Menu("Задача 1.2.1"))),
                        two)))));
        assertThat(rz.select("Задача 2"), is(two));
        assertThat(rz.select("Задача 1.1"), is(oneone));
    }

}