package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFileBuf {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("src/data/input.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
