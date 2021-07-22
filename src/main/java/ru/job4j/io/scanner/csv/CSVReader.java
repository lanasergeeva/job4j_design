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
        log(st, new PrintStream(VALUES.get("out")));
    }


    public List<String> csvParse() throws IOException {
        List<String> list = new ArrayList<>(Arrays.asList(VALUES.get("filter").split(VALUES.get("delimiter")))); //получаю столбцы из фильтра
        try (Scanner sc = new Scanner(Path.of(VALUES.get("path")))
                .useDelimiter(VALUES.get("delimiter"))) {
            String[] array = sc.nextLine().split(VALUES.get("delimiter")); //читаю "шапку"/первую строку со столбцами и закидываю ее в массив
            List<Integer> ints = new ArrayList<>(); //создаю лист для индексов
            for (int i = 0; i < array.length; i++) {
                if (list.contains(array[i])) { //перебираю массив и сравниваю каждое значение с фильтром
                    ints.add(i); //индексы сохраняю в лист
                }
            }
            while (sc.hasNextLine()) { //сканер построчно проходит по файлу со второй строки
                Scanner word = new Scanner(sc.nextLine()).useDelimiter(VALUES.get("delimiter")); //второй сканер для прохода по словам
                while (word.hasNext()) {
                    for (int i = 0; i < array.length; i++) { //array содержит количество столбцов в шапке, а значит и количество значений в строке
                        String w = word.next(); //проходим по значениям
                        if (ints.contains(i)) {
                            list.add(w); //сравниваю столбы со значением по индексу
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void log(List<String> param, PrintStream printStream) {
        for (String st : param) {
            printStream.println(st);
            System.out.println(st);
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
