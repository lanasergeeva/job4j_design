package ru.job4j.serialization;

public class Car {
    private  String model;
    private  String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + '}';
    }
}
