package ru.job4j.gc;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.FieldLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;

public class Sizes {

    public HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        //char[] chars = {'k', }
        String name = "Konstantin";
        byte[] n = name.getBytes(StandardCharsets.UTF_8);
        char[] from = name.toCharArray();
        char[] chars1 = {'K', 'o', 'n', 's', 't', 'a', 'n', 't', 'i', 'n'};
        User6 u6 = new User6(1, name);
        Userch userch = new Userch(chars1);
        UserT p = new UserT(1, userch);
        User35 user11 = new User35(1, "Lana", true);
      /*  System.out.println(ClassLayout.parseClass(User35.class).toPrintable());
        System.out.println(GraphLayout.parseInstance(u6).toFootprint());
        System.out.println(ClassLayout.parseClass(User6.class).toPrintable());
        System.out.println(ClassLayout.parseInstance(u6).toPrintable());
        System.out.println(ClassLayout.parseInstance(n).toPrintable());
        System.out.println(ClassLayout.parseInstance(name).toPrintable());
        System.out.println(ClassLayout.parseInstance(n).toPrintable());
        System.out.println(ClassLayout.parseInstance(chars1).toPrintable());
        System.out.println(ClassLayout.parseInstance(from).toPrintable());
        System.out.println(GraphLayout.parseInstance(p).toFootprint());
        System.out.println(GraphLayout.parseInstance(u6).toFootprint());
        System.out.println(GraphLayout.parseInstance(userch).toFootprint());
        System.out.println(GraphLayout.parseInstance(p).toFootprint());
        System.out.println(GraphLayout.parseInstance(u6).toFootprint());
        System.out.println(ClassLayout.parseInstance(u6).toPrintable());
        System.out.println(ClassLayout.parseInstance(p).toPrintable());
        System.out.println(ClassLayout.parseInstance(userch).toPrintable());*/
        System.out.println(ClassLayout.parseInstance(u6).toPrintable());
        System.out.println(GraphLayout.parseInstance(u6).toFootprint());



    }
}

class User35 {
    private int age;
    private String surname;
    private boolean mal;

    public User35(int age, String surname, boolean mal) {
        this.age = age;
        this.surname = surname;
        this.mal = mal;
    }
}

class User15 {
    private String name;
    private String surname;

    public User15(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

class User2 {
    private int id;
    private String name;
    private String surname;

    public User2(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}

class User4 {

}

class User6 {
    private int age;
    private String name;

    public User6(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Userch {
    private char[] chars;

    public Userch(char[] chars) {
        this.chars = chars;
    }
}

class UserT {
    private int age;
    private Userch user;

    public UserT(int age, Userch user) {
        this.age = age;
        this.user = user;
    }
}








