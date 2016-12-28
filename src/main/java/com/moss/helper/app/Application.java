package com.moss.helper.app;

import static com.moss.helper.utilities.Settings.drives;

import java.io.File;

import com.moss.helper.file.FileHandler;

public class Application {

    public Application() {
        // FileHandler.removeFiles();
        // FileHandler.findFiles(new File("C:/"));
        // FileHandler.findFiles(new File("D:/"));
        for (String driveName : drives) {
            FileHandler.findFiles(new File(driveName + ":/"));
        }
        /*File[] paths;
        FileSystemView fsv = FileSystemView.getFileSystemView();
        paths = File.listRoots();
        for(File path : paths)
        {
            System.out.println("Drive Name: "+path);
            System.out.println("Description: "+fsv.getSystemTypeDescription(path));
        }*/
    }
}
