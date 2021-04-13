package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Student {
    private String name;
    private boolean fullTime;
    private Car car;
    private final String[] subjects;

    public Student(String name, boolean fullTime, Car car, String... subjects) {
        this.name = name;
        this.fullTime = fullTime;
        this.car = car;
        this.subjects = subjects;
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

    public static void main(String[] args) {
        Student student = new Student("Ivan", true, new Car("Nissan Teana", "Red"), "philology",
                "mathematics");
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        /* Модифицируем json-строку */
        String studentJson =
                "{"
                        + "\"name\":Ivan,"
                        + "\"fullTime\":true,"
                        + "\"car\":"
                        + "{"
                        + "\"model\":\"Nissan Teana\","
                        + "\"color\":\"Red\""
                        + "},"
                        + "\"subjects\":"
                        + "[\"philology\",\"mathematics\"]"
                        + "}";
        Student studentMod = gson.fromJson(studentJson, Student.class);
        System.out.println(studentMod);
    }
}
