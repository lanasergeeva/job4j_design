package ru.job4j.io;

import java.io.*;

public class Analizy {

    public boolean stop = false;

    public void unavailable(String source, String target) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            try (BufferedReader in = new BufferedReader(new FileReader(source))) {
                in.lines().filter(line -> !line.isEmpty())
                        .forEach(line -> {
                            String[] array = line.split(" ");
                            if (!stop && (array[0].contains("400") || array[0].contains("500"))) {
                                out.print(array[1] + " to ");
                                stop = true;
                            } else if (stop && (array[0].contains("300") || array[0].contains("200"))) {
                                out.println(array[1]);
                                stop = false;
                            }
                        });
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Analizy a = new Analizy();
        try {
            a.unavailable("src/data/server.log", "src/data/rsl.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
