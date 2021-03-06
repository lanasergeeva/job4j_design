package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        mem.set(index, model);
        return index != -1;
    }

    @Override
    public boolean delete(String id) {
        int index = findByIndex(id);
        if (index != -1) {
            mem.remove(index);
        }
        return index != -1;
    }

    @Override
    public T findById(String id) {
        T check = null;
        for (T type : mem) {
            if (type.getId().equals(id)) {
                check = type;
                break;
            }
        }
        return check;
    }

    public int findByIndex(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
