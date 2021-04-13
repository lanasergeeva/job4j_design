package ru.job4j.serialization;

import com.sun.xml.txw2.annotation.XmlElement;
import org.json.JSONObject;

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

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + '}';
    }

    public static void main(String[] args) {
        Car carr = new Car("Priora", "Black");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model", carr.getModel());
        jsonObject.put("color", carr.getColor());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(carr).toString());
    }
}
