package com.moss.helper.file;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import com.moss.helper.Main;
import com.moss.helper.printer.Printer;
import com.moss.helper.utilities.Settings;

import static com.moss.helper.utilities.Settings.dataDirectory;

public class FileHandler {

    public static final File workingDirectory = getWorkingDirectory();

    private static File getWorkingDirectory() {
        File file = null;
        try {
            file = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (Settings.logMode) {
            System.out.println(file.toString());
            Printer.printOutputToFile(file.toString(), Settings.logFile);
        }
        return file;
    }


    public static void findFile(String name, File directory) {
        File[] list = directory.listFiles();
        if (list != null)
            for (File file : list) {
                if (file.isDirectory()) {
                    findFile(name, file);
                } else if (name.equalsIgnoreCase(file.getName())) {
                    System.out.println("Found file : " + file.getPath());
                    System.out.println("Copy file  : " + file.toString() + " into " + dataDirectory.toString());
                    String copyFilePath = dataDirectory + "\\" + name;
                    File copyFile = new File(copyFilePath);
                    int copyNumber = 1;
                    while (copyFile.exists()) {
                        copyFile = new File(dataDirectory + "\\" + copyNumber + name);
                        copyNumber++;
                    }
                    copyFile(file, copyFile);
                }
            }
    }


    private static void copyFile(File source, File destination) {
        try {
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
