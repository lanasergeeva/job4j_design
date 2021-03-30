package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PostTest {

    @Test
    public void whenAdd() {
        Map<String, Set<String>> user = new HashMap<>();
        user.put("LanaLana", Set.of("lana@gmail.com", "lanalana@gmail.com", "lanana@gmail.com"));
        user.put("Oleg2000", Set.of("oleg@gmail.com", "oooleg@gmail.com", "legolego@gmail.com"));
        user.put("Lana2", Set.of("lana@gmail.com", "lanaqwerty@gmail.com"));
        user.put("Oleg2", Set.of("oleg@gmail.com", "oooleg@gmail.com"));
        user.put("Oleg3", Set.of("olegolegoleg@gmail.com", "oooleg@gmail.com"));
        Map<String, Set<String>> rsl = new HashMap<>();
        rsl.put("LanaLana", Set.of("lana@gmail.com", "lanalana@gmail.com", "lanana@gmail.com", "lanaqwerty@gmail.com"));
        rsl.put("Oleg2000", Set.of("oleg@gmail.com", "oooleg@gmail.com", "legolego@gmail.com", "olegolegoleg@gmail.com"));
        assertThat(new Post().unique(user), is(rsl));
    }
}