package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest  {
    @Test
    public void whenAdd() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddDubl() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("first");
        array.add("second");
        SimpleSet<String> check = new SimpleSet<>();
        check.add("first");
        check.add("second");
        assertThat(array, is(check));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }

    @Test
    public void elementIsNull() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add(null);
        assertTrue(Objects.isNull(array.iterator().next()));
    }
}