package ru.job4j.gc.cache;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertTrue;

public class DirFileCacheTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testLoadTrue() throws IOException {
        File dir = folder.newFolder("dir");
        File source = folder.newFile("dir/test.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hello how are you");
        }
        DirFileCache dirFileCache = new DirFileCache(dir.getAbsolutePath());
        String st = dirFileCache.load("test.txt");
        assertTrue(st.startsWith("hello"));
    }

    @Test(expected = IOException.class)
    public void whenWrongDir() throws IOException {
        File dir = folder.newFolder("dir");
        File source = folder.newFile("wrong/test.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("hello how are you");
        }
        DirFileCache dirFileCache = new DirFileCache(dir.getAbsolutePath());
        String st = dirFileCache.load("test.txt");
    }
}

