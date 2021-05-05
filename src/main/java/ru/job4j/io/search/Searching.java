package ru.job4j.io.search;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Searching {
    private static final Map<String, String> VALUES = new HashMap<>();

    private void parseValidate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("You have to write 4 parametrs");
        }
        Arrays.stream(args)
                .filter(s -> s.startsWith("-"))
                .map(s -> s.replace("-", ""))
                .forEach(s -> {
                    String[] array = s.split("=", 2);
                    if (array[1].isEmpty()) {
                        throw new IllegalArgumentException("Wrong parameters");
                    } else {
                        VALUES.put(array[0], array[1]);
                    }
                });
        List<String> check = List.of("d", "t", "n", "o");
        for (String key : check) {
            if (!VALUES.containsKey(key)) {
                throw new IllegalArgumentException("You need to correct parameters of log.\n"
                        + "-d - директория, в которой начинать поиск.\n"
                        + "-n - имя файла, маска, либо регулярное выражение.\n"
                        + "-t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.\n"
                        + "-o - результат записать в файл.");
            }
        }
    }

    public static List<Path> find(Path path, Predicate<Path> predicate) throws IOException {
        FileTreeSearching searching = new FileTreeSearching(predicate);
        Files.walkFileTree(path, searching);
        return searching.getPaths();
    }

    public static void log(List<Path> list) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(VALUES.get("o"))
                ))) {
            for (Path path : list) {
                out.println(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Predicate<Path> type(String name) {
        Predicate<Path> predicate = null;
        if (VALUES.get("t").equals("name")) {
            predicate = path -> path.toFile().getName().equals(name);
        } else if (VALUES.get("t").equals("mask")) {
            predicate = path -> path.toFile().getName().contains(name);
        } else if (VALUES.get("t").equals("regex")) {
            predicate = path -> path.toFile().getName().contains(name);
        }
        return predicate;
    }

    public static void main(String[] args) throws IOException {
        Searching search = new Searching();
        search.parseValidate(args);
        Predicate<Path> predicate = search.type(VALUES.get("n"));
        List<Path> rsl = find(Paths.get(VALUES.get("d")), predicate);
        log(rsl);
        System.out.println("Done!");
    }
}
