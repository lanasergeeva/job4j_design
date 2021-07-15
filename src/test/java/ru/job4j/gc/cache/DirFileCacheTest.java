package ru.job4j.gc.cache;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class DirFileCacheTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "C:\\Users\\Лана\\Desktop\\Soft\\";
        DirFileCache dir = new DirFileCache(path);
        path = dir.load("Ana.txt");
        assertTrue(path.startsWith("You"));
    }
}