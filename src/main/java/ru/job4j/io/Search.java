package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        //Path start = Paths.get(".");
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null or there are is not parameters of files");
        }
        Path start = Paths.get(args[1]);
        search(start, p -> !p.toFile().getName().endsWith(args[0]))/*forEach(System.out::println*/;
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        PrintFiles searcher = new PrintFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
