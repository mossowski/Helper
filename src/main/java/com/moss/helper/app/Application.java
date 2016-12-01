package com.moss.helper.app;

import com.moss.helper.file.FileHandler;
import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class Application {

    public Application() {
        //FileHandler.removeFiles();
        FileHandler.findFiles(new File("C:/"));
        FileHandler.findFiles(new File("D:/"));

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
