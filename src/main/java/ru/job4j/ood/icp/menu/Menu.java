package ru.job4j.ood.icp.menu;

import java.util.LinkedList;
import java.util.List;

public class Menu {
    private String name;
    private List<Menu> listMenu = new LinkedList<>();

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String name, List<Menu> listMenu) {
        this.name = name;
        this.listMenu = listMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<Menu> listMenu) {
        this.listMenu = listMenu;
    }

    @Override
    public String toString() {
        return "Menu{"
               + "name='" + name + '\''
               + ", listMenu=" + listMenu
               + '}';
    }
}
