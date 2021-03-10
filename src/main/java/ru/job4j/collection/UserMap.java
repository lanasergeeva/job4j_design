package ru.job4j.collection;

import java.util.*;

public class UserMap {
    public static void main(String[] args) {
        User userOne = new User("Ivan", 1, new GregorianCalendar(1990, Calendar.AUGUST, 1));
        User userTwo = new User("Ivan", 1, new GregorianCalendar(1990, Calendar.AUGUST, 1));
        Map<User, Object> mapUser = new HashMap<>();
        mapUser.put(userOne, 1);
        mapUser.put(userTwo, 2);
        for (User us : mapUser.keySet()) {
            Object ob = mapUser.get(us);
            System.out.println(us + " = " + ob);
        }
        System.out.println(userOne.equals(userTwo));




    }
}
