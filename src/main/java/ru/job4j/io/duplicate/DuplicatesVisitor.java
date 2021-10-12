package ru.job4j.io.duplicate;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> files = new HashSet<>();
    private Map<FileProperty, Path> map = new HashMap<>();


    public FileVisitResult visitFileFirst(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (files.contains(fileProperty)) {
            System.out.println(file.toAbsolutePath());
        } else {
            files.add(fileProperty);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (map.containsKey(fileProperty)) {
            System.out.println("First duplicate path is " + map.get(fileProperty));
            System.out.println("Second duplicate path is  " + file.toAbsolutePath());
        } else {
            map.put(fileProperty, file);
        }
        return FileVisitResult.CONTINUE;
    }
}
