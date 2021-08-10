package ru.job4j.io.scanner.csv;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class CSVReaderTest  {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /*@Test
    public void testLoadTrue() throws IOException {
        List<String> st = new ArrayList<>();
        CSVReader cs = new CSVReader();
        st = cs.csvParse();
        assertTrue(st.isEmpty());
    }*/
}
