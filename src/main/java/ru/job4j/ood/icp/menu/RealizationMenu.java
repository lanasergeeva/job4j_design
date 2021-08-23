package ru.job4j.ood.icp.menu;

import java.util.LinkedList;
import java.util.List;

public class RealizationMenu implements ShowMenu, SelectMenu, Action {

    private List<Menu> list = new LinkedList<>();

    public List<Menu> getList() {
        return list;
    }

    @Override
    public void show(Menu first) {
        for (Menu menu : first.getListMenu()) {
            System.out.println(menu.getName());
            list.add(menu);
            show(menu);
        }
    }

    @Override
    public Menu select(String name) {
        Menu rsl = null;
        for (Menu menu : list) {
            if (menu.getName().equals(name)) {
                rsl = menu;
            }
        }
        return rsl;
    }

    @Override
    public void action(String name) {
        Menu menu = select(name);
        System.out.println("Do something with " + menu);
    }

    public static void main(String[] args) {
        RealizationMenu rz = new RealizationMenu();
        rz.show(new Menu("Menu",
                List.of(new Menu("Задача 1",
                                List.of(new Menu("Задача 1.1"),
                                        new Menu("Задача 1.2"))),
                        new Menu("Задача 2", List.of(new Menu("Задача 2.1"), new Menu("Задача 2.2"))),
                        new Menu("Задача 3", List.of(new Menu("Задача 3.1", List.of(new Menu("Задача 3.1.1"),
                                new Menu("Задача 3.1.2"))))))));
        System.out.println(rz.getList());
        System.out.println(rz.select("Задача 2"));
    }
}
