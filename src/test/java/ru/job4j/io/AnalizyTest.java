package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenOnlyPeriod() throws IOException {
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        analizy.unavailable("server.log", target.getAbsolutePath());
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(sb::append);
        }
        assertThat(sb.toString(), is("10:57:01 to 10:59:01"
                + "11:01:02 to 11:02:02"));
    }
}