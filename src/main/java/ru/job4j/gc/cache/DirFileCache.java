package ru.job4j.gc.cache;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /**
     * Этим методом загружаем из файла текст в папке по пути chachingDir
     *
     * @param key относительный путь файла
     * @return текст из файла
     */
    @Override
    protected String load(String key) {
        String rsl = "";
        try {
            rsl = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
