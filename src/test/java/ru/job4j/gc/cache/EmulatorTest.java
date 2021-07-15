package ru.job4j.gc.cache;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class EmulatorTest {

    @Test
    public void testGetWhenFileFromAnotherDirectory() throws IOException {
        AbstractCache<String, String> abs =
                new Emulator("C:\\Users\\Лана\\Desktop\\Soft");
        String st = abs.get("notexist.txt");
        assertFalse(abs.cache.containsKey("notexist"));
    }

    @Test
    public void testLoad() throws IOException {
        AbstractCache<String, String> abs =
                new Emulator("C:\\Users\\Лана\\Desktop\\Soft");
        String st = abs.load("notexist.txt");
        assertTrue(st.isEmpty());
    }

    @Test
    public void testPutwhenFileFromAnother() throws IOException {
        AbstractCache<String, String> abs =
                new Emulator("C:\\Users\\Лана\\Desktop\\Soft");
        abs.put("notexist.txt", abs.load("notexist.txt"));
        assertTrue(abs.cache.isEmpty());
    }

}