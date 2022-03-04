package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("src/main/resources/app1.properties");
        config.load();
        assertThat(config.value("hibernate.connection.password"), is("lana90max"));
    }

    @Test
    public void whenThereAreComment() {
        Config config = new Config("src/main/resources/app1.properties");
        config.load();
        assertThat(config.value("hibernate.connection.password"), is("lana90max"));
    }

    @Test
    public void whenAre2() {
        Config config = new Config("src/main/resources/app1.properties");
        config.load();
        assertThat(config.value("hibernate.connection.password"), is("lana90max"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenThereAreEmptyValue() {
        Config config = new Config("src/main/resources/app2.properties");
        config.load();
    }
}