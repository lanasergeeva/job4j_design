package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> list = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public List<String> getList() {
        return list;
    }

    public void run() {
        boolean result = true;
        Scanner scanner = new Scanner(System.in);
        String text = "";
        listAnswers();
        List<String> list = new LinkedList<>();
        while (!text.equals(OUT)) {
            System.out.println("Введите слово");
            text = scanner.nextLine();
            if (STOP.equals(text)) {
                result = false;
            }
            if (CONTINUE.equals(text)) {
                result = true;
            }
            list.add(text);
            if (result && !text.equals(OUT)) {
                String answer = getRandom();
                System.out.println(answer);
                list.add(answer);
            }
        }
        log(list);
    }

    public void listAnswers() {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            list = in.lines()
                    .flatMap(line -> Stream.of(line.split("\\s+")))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size() - 1);
        return list.get(index);
    }

    public void log(List<String> list) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {
            for (String s : list) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\src\\data\\chat.txt", "C:\\projects\\job4j_design\\src\\data\\bot.txt");
        cc.run();
        cc.listAnswers();
        System.out.println(cc.getList().toString());
        System.out.println(cc.getList().size());
        System.out.println(cc.getRandom());
    }
}
