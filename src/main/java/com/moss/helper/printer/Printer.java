package com.moss.helper.printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.moss.helper.utilities.Settings;

public class Printer {

    public static void printOutputToFile(String output, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(output);
        } catch (IOException e) {
            if (Settings.errorMode) {
                String errorOutput = new String(e.getMessage());
                printOutputToFile(errorOutput, Settings.errorFile);
            }
        }
    }

}
