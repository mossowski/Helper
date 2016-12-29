package com.moss.helper.utilities;

import java.util.ArrayList;

import com.moss.helper.file.FileHandler;
import com.moss.helper.file.Reader;

public class Settings {

    // application settings
    public final static String logFile = "helper.log";
    public final static String errorFile = "error.log";
    public final static boolean logMode = false;
    public final static boolean errorMode = false;

    // paths
    public final static String dataDirectory = FileHandler.workingDirectory + "\\data\\";
    public final static String documentsDirectory = dataDirectory + "documents\\";
    public final static String imagesDirectory = dataDirectory + "images\\";
    public final static String mostWantedDirectory = dataDirectory + "mostwanted\\";
    public final static String settingsDirectory = FileHandler.workingDirectory + "\\settings\\";
    public final static String settingsFile = settingsDirectory + "settings.properties";

    // drives
    public final static ArrayList<String> drives = Reader.loadData(settingsFile);

    // mostwanted extensions
    public enum MostWanted {
        db, sql
    }

    // documents extensions
    public enum DocumentExtensions {
        cfg, csv, doc, docx, ini, json, odt, pdf, ppt, pptx, rc, reg, rtf, txt, xls, xml
    }

    // images extensions
    public enum ImageExtensions {
        bmp, gif, jpeg, jpg, png, swf
    }
}
