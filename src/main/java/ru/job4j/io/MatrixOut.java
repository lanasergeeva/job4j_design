package ru.job4j.io;

import java.io.FileOutputStream;

public class MatrixOut {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result1.txt")) {
            int[][] array = new int[9][9];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    out.write(Integer.toString((i + 1) * (j + 1)).getBytes());
                    out.write('\t');
                }
                out.write('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
