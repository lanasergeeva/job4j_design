package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {
    Analize.User user1 = new Analize.User(10, "Oleg");
    Analize.User user2 = new Analize.User(15, "Nikita");
    Analize.User user3 = new Analize.User(20, "Igor");
    Analize.User user4 = new Analize.User(20, "Tim");
    Analize.User user5 = new Analize.User(25, "Uriy");
    Analize.User user6 = new Analize.User(26, "Ratmir");
    Analize.User user7 = new Analize.User(27, "Michel");
    Analize.User user8 = new Analize.User(27, "Nazar");


    @Test
    public void whenTheSame() {
        List<Analize.User> list = new ArrayList<>(Arrays.asList(user1, user2, user3, user5));
        List<Analize.User> check = new ArrayList<>(Arrays.asList(user1, user2, user3, user5));
        Analize.Info info = new Analize().diff(list, check);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenAdd() {
        List<Analize.User> list = new ArrayList<>(Arrays.asList(user1, user2, user3));
        List<Analize.User> check = new ArrayList<>(Arrays.asList(user1, user2, user3, user5, user6, user7));
        Analize.Info info = new Analize().diff(list, check);
        assertThat(info.getAdded(), is(3));
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenAddAndChange() {
        List<Analize.User> list = new ArrayList<>(Arrays.asList(user1, user2, user3, user7));
        List<Analize.User> check = new ArrayList<>(Arrays.asList(user1, user2, user4, user5, user8));
        Analize.Info info = new Analize().diff(list, check);
        assertThat(info.getAdded(), is(1));
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(2));
    }

    @Test
    public void whenDelete() {
        List<Analize.User> list = new ArrayList<>(Arrays.asList(user1, user2, user3, user5, user6, user7));
        List<Analize.User> check = new ArrayList<>(Arrays.asList(user2, user3));
        Analize.Info info = new Analize().diff(list, check);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getDeleted(), is(4));
        assertThat(info.getChanged(), is(0));
    }

    @Test
    public void whenEmpty() {
        List<Analize.User> list = new ArrayList<>();
        List<Analize.User> check = new ArrayList<>(Arrays.asList(user2, user3));
        Analize.Info info = new Analize().diff(list, check);
        assertThat(info.getAdded(), is(2));
        assertThat(info.getDeleted(), is(0));
        assertThat(info.getChanged(), is(0));
    }
}