package ru.job4j.generics;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;
public class SimpleArrayTest {

    @Test
    public void whenOnlyAdd() {
        Integer[] array = new Integer[50];
        SimpleArray<Integer> test = new SimpleArray<>(array);
        test.add(50);
        int check = test.get(0);
        assertThat(check, is(50));
    }

    @Test
    public void whenAddAndSet() {
        Integer[] array = new Integer[50];
        SimpleArray<Integer> test = new SimpleArray<>(array);
        test.add(50);
        test.add(100);
        test.set(1, 200);
        int check = test.get(1);
        assertThat(check, is(200));
    }

    @Test
    public void whenAddSetRemove() {
        Integer[] array = new Integer[50];
        SimpleArray<Integer> test = new SimpleArray<>(array);
        test.add(50);
        test.add(100);
        test.add(200);
        test.add(300);
        test.remove(1);
        test.set(2, 400);
        Integer[] rsl = new Integer[50];
        SimpleArray<Integer> test2 = new SimpleArray<>(rsl);
        test2.add(50);
        test2.add(200);
        test2.add(400);
        assertEquals(test, test2);
    }

    @Test
    public void whenIteration() {
        Integer[] array = new Integer[50];
        SimpleArray<Integer> test = new SimpleArray<>(array);
        test.add(50);
        int check = test.iterator().next();
        assertThat(check, is(50));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenExep() {
        Integer[] array = new Integer[50];
        SimpleArray<Integer> test = new SimpleArray<>(array);
        test.iterator().next();
    }
}