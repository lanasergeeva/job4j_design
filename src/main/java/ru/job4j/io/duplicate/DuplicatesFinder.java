package ru.job4j.io.duplicate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Path.of("C:\\Users\\Лана\\Desktop\\"), new DuplicatesVisitor());
    }
}
