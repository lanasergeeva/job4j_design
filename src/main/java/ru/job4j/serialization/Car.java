package ru.job4j.serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "car")
public class Car {
    @XmlAttribute
    private String model;
    @XmlAttribute
    private String color;

    public Car() {
    }

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
