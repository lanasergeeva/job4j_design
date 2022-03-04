package ru.job4j.ood.lsp.store;

import java.util.LinkedList;
import java.util.List;

public class ControllQuality {
    private final List<Store> storeList;

    public ControllQuality(List<Store> storeList) {
        this.storeList = storeList;
    }

    public void executeStore(Food food) {
        for (Store store : storeList) {
            if (store.accept(food)) {
                store.add(food);
                break;
            }
        }
    }

    public void resort() {
        List<Food> all = new LinkedList<>();
        for (Store store : storeList) {
            all.addAll(store.getList());
        }
        for (Food food : all) {
            executeStore(food);
        }
    }
}
