package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ResultFileBuf {
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("src/data/hello.txt")
                ))) {
            out.write("Hello, world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
