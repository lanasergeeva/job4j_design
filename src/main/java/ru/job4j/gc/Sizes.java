package ru.job4j.gc;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sizes {

    public HashMap<String, String> hashMap = new HashMap<>();

    public static void main(String[] args) {
        /*System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(A.class).toPrintable());*/
        int[] array = {1, 2, 1, 4, 4, 4};
        System.out.println(GraphLayout.parseInstance((Object) array).toFootprint());
        System.out.println("array");
        int[] array3 = new int[1000];
        System.out.println(GraphLayout.parseInstance((Object) array3).toFootprint());
        System.out.println("array");
        Integer as = 100;
        System.out.println(GraphLayout.parseInstance((Object) as).toFootprint());
        User user = new User();
        System.out.println(GraphLayout.parseInstance((Object) user).toFootprint());
        User user2 = new User("styytrynfifnfnffww334", "kgnjf945jh4hf8gjhgg");
        System.out.println(GraphLayout.parseInstance(user2).toFootprint());
        User userdd = new User("Ivan", "admin");
        System.out.println(GraphLayout.parseInstance(userdd).toFootprint());
        User user3 = new User("skd", "sa");
        System.out.println(GraphLayout.parseInstance(user3).toFootprint());
        /*String name = "sdaijhdshfsanfosf";
        System.out.println(GraphLayout.parseInstance(name).toFootprint());
        String name2 = "sdaijhdshfsanfosf dsfdssssssssss";
        System.out.println(GraphLayout.parseInstance(name2).toFootprint());*/


    }

    public static class A {
        int a;
        String s;
        double d;
        String name = "sdaijhdshfsanfosf";
        String name2 = "fgdgddddddddddddddddddddddddddddddddddddddddddddddddgd";
        Person persin = new Person(5, "Anaaaaaaaaaaaaaaaaaaa");
        Person persin2 = new Person(5, name2);
        int[] array2 = new int[1000];
        int[] array = {1, 2, 1, 4, 4, 4};
        String[] sarray = {name, name2};
        int b;
        int i = 12568;
    }
}



