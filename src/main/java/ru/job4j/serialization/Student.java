package ru.job4j.serialization;

import org.json.JSONObject;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private boolean fullTime;

    private Car car;
    @XmlElementWrapper(name = "subjects")
    @XmlElement(name = "subject")
    private String[] subjects;

    public Student() {
    }

    public Student(String name, boolean fullTime, Car car, String... subjects) {
        this.name = name;
        this.fullTime = fullTime;
        this.car = car;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public Car getCar() {
        return car;
    }

    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", fullTime=" + fullTime
                + ", car=" + car
                + ", subjects=" + Arrays.toString(subjects)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        JSONObject jsonCar = new JSONObject("{\"model\":\"Nissan Teana\", \"color\":\"black\"}");
        System.out.println(jsonCar.toString());
        Student student = new Student("Ivan", true, new Car("Nissan Teana", "Red"), "philology",
                "mathematics");
        Map<String, String> st = new HashMap<>();
        JSONObject js = new JSONObject(st);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", student.getName());
        jsonObject.put("fullTime", student.isFullTime());
        jsonObject.put("car", jsonCar);
        jsonObject.put("subjects", student.getSubjects());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(student).toString());
    }
}

