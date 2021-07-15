package ru.job4j.gc.cache;

import java.io.IOException;

public class Emulator extends DirFileCache {

    @Override
    public void put(String key, String value) {
        super.put(key, value);
    }

    @Override
    public String get(String key) throws IOException {
        return super.get(key);
    }

    public Emulator(String cachingDir) {
        super(cachingDir);
    }

    @Override
    protected String load(String key) {
        return super.load(key);
    }

    public static void main(String[] args) throws IOException {
        AbstractCache<String, String> abs = new Emulator("C:\\Users\\Лана\\Desktop\\Soft");
        abs.put("Ana.txt", abs.load("Ana.txt"));
        abs.put("Bna.txt", abs.load("Bna.txt"));
        System.out.println(abs.cache);
        String bna = abs.get("Bna.txt");
        System.out.println(bna);
    }
}

