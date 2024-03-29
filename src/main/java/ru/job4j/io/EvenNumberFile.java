package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("src/data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] array = text.toString().split(System.lineSeparator());
            for (String line : array) {
                System.out.println(Integer.parseInt(line) % 2 == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

