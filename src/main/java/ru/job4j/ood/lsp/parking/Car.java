package ru.job4j.ood.lsp.parking;

public class Car implements Transport {

    private int size;
    public Car() {
        this.size = 1;
    }

    @Override
    public int getSize() {
        return size;
    }
}
