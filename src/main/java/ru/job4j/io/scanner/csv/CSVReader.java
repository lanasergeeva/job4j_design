package ru.job4j.io.scanner.csv;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    private static final Map<String, String> VALUES = new HashMap<>();

    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader();
        reader.parseValidate(args);
        List<String> st;
        st = reader.csvParse();
        log(st);
    }


    public List<String> csvParse() throws IOException {
        List<String> list = new ArrayList<>(Arrays.asList(VALUES.get("filter").split(VALUES.get("delimiter"))));
        try (Scanner sc = new Scanner(Path.of(VALUES.get("path")))
                .useDelimiter(VALUES.get("delimiter"))) {
            String[] array = sc.nextLine().split(VALUES.get("delimiter"));
            Set<Integer> ints = new HashSet<>();
            for (int i = 0; i < array.length; i++) {
                if (list.contains(array[i])) {
                    ints.add(i);
                }
            }
            while (sc.hasNextLine()) {
                Scanner word = new Scanner(sc.nextLine()).useDelimiter(VALUES.get("delimiter"));
                while (word.hasNext()) {
                    for (int i = 0; i < array.length; i++) {
                        String w = word.next();
                        if (ints.contains(i)) {
                            list.add(w);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void log(List<String> param) {
        String type = VALUES.get("out");
        if (type.equals("stdout")) {
            for (String st : param) {
                System.out.println(st);
            }
        } else {
            try (PrintStream printStream = new PrintStream(type)) {
                for (String st : param) {
                    printStream.println(st);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void parseValidate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("You have to write 4 parametrs");
        }
        Arrays.stream(args)
                .filter(s -> s.startsWith("-"))
                .map(s -> s.replace("-", ""))
                .forEach(s -> {
                    String[] array = s.split("=", 2);
                    if (array[1].isEmpty()) {
                        throw new IllegalArgumentException("Wrong parameters");
                    } else {
                        VALUES.put(array[0], array[1]);
                    }
                });
        List<String> check = List.of("path", "delimiter", "out", "filter");
        for (String key : check) {
            if (!VALUES.containsKey(key)) {
                throw new IllegalArgumentException("You need to correct parameters of log.\n"
                        + "-path - csv файл,который нужно парсить.\n"
                        + "-delimiter - разделитель, который используют в csv файле.\n"
                        + "-out - путь к файлу или stdout.\n"
                        + "-filter - столбцы, которые будут использоваться.");
            }
        }
    }
}
