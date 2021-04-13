package ru.job4j.serialization;

/*import com.google.gson.Gson;
import com.google.gson.GsonBuilder;*/

import org.json.JSONObject;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        /* JSONObject из json-строки строки */
        JSONObject jsonCar = new JSONObject("{\"model\":\"Nissan Teana\", \"color\":\"black\"}");
        System.out.println(jsonCar.toString());
        /* JSONObject напрямую методом put */
        Student student = new Student("Ivan", true, new Car("Nissan Teana", "Red"), "philology",
                "mathematics");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", student.getName());
        jsonObject.put("fullTime", student.isFullTime());
        jsonObject.put("car", jsonCar);
        jsonObject.put("subjects", student.getSubjects());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(student).toString());
    }
}

       /* JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String result;
        try (StringWriter writer = new StringWriter()) {
            //cериализуем
            marshaller.marshal(student, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            // десериализуем
            Student rsl = (Student) unmarshaller.unmarshal(reader);
            System.out.println(rsl);
        }*/



        /*Student student = new Student("Ivan", true, new Car("Nissan Teana", "Red"), "philology",
                "mathematics");
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        *//* Модифицируем json-строку *//*
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
    }*/

