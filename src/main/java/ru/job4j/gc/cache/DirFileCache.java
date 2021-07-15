package ru.job4j.gc.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder builder = new StringBuilder();
        Set<Path> set = new HashSet<>();
        try {
            set = Files.walk(Paths.get(cachingDir))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("Wrong directory or is not exist");
            e.printStackTrace();
        }
        for (Path path : set) {
            String name = path.getFileName().toString();
            if (name.equals(key)) {
                try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
                    br.lines()
                            .map(line -> line + System.lineSeparator())
                            .forEach(builder::append);
                } catch (IOException e) {
                    System.out.println("Wrong path");
                    e.printStackTrace();
                }
                break;
            }
        }
        return builder.toString();
    }
}
