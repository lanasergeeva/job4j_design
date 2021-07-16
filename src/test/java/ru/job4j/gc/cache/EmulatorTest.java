package ru.job4j.gc.cache;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EmulatorTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void testGetandPut() throws IOException {
        File dir = folder.newFolder("dir");
        File source1 = folder.newFile("dir/test.txt");
        File source2 = folder.newFile("dir/test2.txt");
        try (PrintWriter out = new PrintWriter(source1)) {
            out.println("hello how are you");
        }
        try (PrintWriter out = new PrintWriter(source2)) {
            out.println("how are you");
        }
        AbstractCache<String, String> abs =
                new Emulator(dir.getAbsolutePath());
        abs.put(source1.getName(), abs.load(source1.getName()));
        abs.get(source2.getName());
        assertEquals(2, abs.cache.size());
    }
}