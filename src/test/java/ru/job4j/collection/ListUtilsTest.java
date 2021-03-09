package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.*;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.addBefore(list, 2, 6);
        List<Integer> check = new ArrayList<>(Arrays.asList(1, 2, 6, 3, 4, 5));
        assertThat(list, is(check));
    }

    @Test
    public void whenAddAfter() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.addAfter(list, 1, 6);
        List<Integer> check = new ArrayList<>(Arrays.asList(1, 2, 6, 3, 4, 5));
        assertThat(list, is(check));
    }

    @Test
    public void whenRemove() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.removeIf(list, el -> el == 2);
        List<Integer> check = new ArrayList<>(Arrays.asList(1, 3, 4, 5));
        assertThat(list, is(check));
    }

    @Test
    public void whenReplace() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ListUtils.replaceIf(list, el -> el == 1, 6);
        List<Integer> check = new ArrayList<>(Arrays.asList(6, 2, 3, 4, 5));
        assertThat(list, is(check));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> test = new ArrayList<>(Arrays.asList(1, 3, 5));
        ListUtils.removeAll(list, test);
        List<Integer> check = new ArrayList<>(Arrays.asList(2, 4, 6));
        assertThat(list, is(check));
    }

    @Test
    public void whenAddBefore2() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }
}