package ru.job4j.io;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenOnlyPeriod() throws IOException {
        String source = "server.log";
        String target = "rsl.log";
        Analizy analizy = new Analizy();
        try {
            analizy.unavailable(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        try (BufferedReader in = new BufferedReader(new FileReader("rsl.log"))) {
            in.lines().forEach(sb::append);
        }
        assertThat(sb.toString(), is("10:57:01 to 10:59:01"
                + "11:01:02 to 11:02:02"));
    }
}