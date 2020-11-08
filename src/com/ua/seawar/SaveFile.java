package com.ua.seawar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.ua.seawar.Lab3.battle;

public class SaveFile {
    private String pathname;
    private String[][] array1, array2;

    public SaveFile(String[][] array1, String[][] array2) {
        this.array1 = array1;
        this.array2 = array2;
        pathname = "C:/QuickAccess/result.txt";
    }

    public SaveFile(String pathname, String[][] array1, String[][] array2) {
        this(array1, array2);
        this.pathname = pathname;
    }

    public String getPathname() {
        return pathname;
    }

    public boolean saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathname));) {
            bw.write("Итоговые результаты игры:");
            bw.newLine();
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array1[0].length; j++) {
                    if (i == 0 && j == 0) {
                        bw.write("@1");
                    }
                    bw.write(array1[i][j] + "\t");
                }
                for (int j = 0; j < array2[0].length; j++) {
                    if (i == 0 && j == 0) {
                        bw.write("@2");
                    }
                    bw.write(array2[i][j] + "\t");

                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
