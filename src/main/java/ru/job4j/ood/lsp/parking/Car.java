package ru.job4j.ood.lsp.parking;

public class Car implements Transport {

    private int size;
    public Car(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
