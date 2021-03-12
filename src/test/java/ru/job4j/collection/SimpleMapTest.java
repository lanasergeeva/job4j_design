package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {
    @Test
    public void whenAddAndGet() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("first", "second");
        String value = map.get("first");
        assertThat(value, is("second"));
    }

    @Test
    public void whenAddThenDelete() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("first", "second");
        assertTrue(map.delete("first"));

    }

    @Test
    public void whenAddThenIt() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("first", "second");
        map.insert("one", "two");
        Iterator<Node<String, String>> it = map.iterator();
        assertThat(it.next(), is(new Node<>("first", "second")));
        assertThat(it.next(), is(new Node<>("one", "two")));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleMap<String, String> map = new SimpleMap<>();
        map.insert("first", "second");
        Iterator<Node<String, String>> it = map.iterator();
        map.insert("one", "two");
        it.next();
    }
}