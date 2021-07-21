package ru.job4j.io.scanner.csv;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {
    private static final Map<String, String> VALUES = new HashMap<>();

    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader();
        reader.parseValidate(args);
        Map<String, List<String>> map;
        map = reader.csvParse();
        log(map);
    }


    public Map<String, List<String>> csvParse() {
        List<String> list;
        Map<String, List<String>> map = new HashMap<>();
        try (Scanner sc = new Scanner(Path.of(VALUES.get("path")))
                .useDelimiter(VALUES.get("delimiter"))) {
            String first = sc.nextLine();
            String[] array = first.split(VALUES.get("delimiter"));
            List<String> filter = Arrays.asList(VALUES.get("filter").split(VALUES.get("delimiter")));
            for (String s : array) {
                if (filter.contains(s)) {
                    map.put(s, new ArrayList<>());
                }
            }
            while (sc.hasNextLine()) {
                Scanner word = new Scanner(sc.nextLine()).useDelimiter(VALUES.get("delimiter"));
                while (word.hasNext()) {
                    for (String sr : array) {
                        String w = word.next();
                        if (filter.contains(sr)) {
                            list = map.get(sr);
                            list.add(w);
                            map.put(sr, list);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void log(Map<String, List<String>> param) {
        if (VALUES.get("out").equals("stdout")) {
            for (Map.Entry<String, List<String>> entry : param.entrySet()) {
                System.out.println(entry.getKey() + entry.getValue());
            }
            System.out.println("In console");
        } else if (new File(VALUES.get("out")).isAbsolute()) {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(VALUES.get("out"))
                    ))) {
                for (Map.Entry<String, List<String>> entry : param.entrySet()) {
                    out.println(entry.getKey());
                    out.println(entry.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("In out file");
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
