package ru.job4j.kiss;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxMinTest {
    @Test
    public void whenMax() {
        List<Integer> list = new ArrayList<>(Arrays.asList(14, 2, 34, 15, 1));
        MaxMin max = new MaxMin();
        int rsl = max.max(list, Comparator.comparingInt(numb -> numb));
        assertThat(rsl, is(34));
    }

    @Test
    public void whenMin() {
        List<Integer> list = new ArrayList<>(Arrays.asList(14, 2, 34, 15, 1));
        MaxMin max = new MaxMin();
        int rsl = max.min(list, Comparator.comparingInt(numb -> numb));
        assertThat(rsl, is(1));
    }

    @Test
    public void whenMin1() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MaxMin max = new MaxMin();
        int rsl = max.min(list, Comparator.comparingInt(numb -> numb));
        assertThat(rsl, is(1));
    }

    @Test
    public void whenMax2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MaxMin max = new MaxMin();
        int rsl = max.max(list, Comparator.comparingInt(numb -> numb));
        assertThat(rsl, is(5));
    }



}