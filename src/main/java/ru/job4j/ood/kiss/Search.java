package ru.job4j.ood.kiss;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {
    //добавила для работы метода
    public static List<File> files = new ArrayList<>();

    static List<File> findBy(Predicate<File> predicate) {
        List<File> rsl = new ArrayList<>();
        for (File file : files) {
            if (predicate.test(file)) {
                rsl.add(file);
            }
        }
        return rsl;
    }

    static List<File> findByMask(String mask) {
        return findBy(file -> Pattern.matches(mask, file.getName()));
    }

    static List<File> findByName(String name) {
        return findBy(file -> file.getName().equals(name));
    }

    static List<File> findByExt(String ext) {
        return findBy(file -> file.getName().endsWith(ext));
    }
}
