package ru.job4j.ood.template;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.*;

public class GeneratorTest {

    @Test
    public void whenCorrect() {
        String test = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "David");
        map.put("subject", "you");
        Temp temp = new Temp();
        String rsl = "I am a David, Who are you?";
        assertEquals(rsl, temp.produce(test, map));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectTemplate() {
        String test = "I am a ${name}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "David");
        map.put("subject", "you");
        Temp temp = new Temp();
        temp.produce(test, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectKeys() {
        String test = "I am a ${name}, Who are ${subject}?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "David");
        Temp temp = new Temp();
        temp.produce(test, map);
    }
}
