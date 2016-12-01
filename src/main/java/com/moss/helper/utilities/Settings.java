package com.moss.helper.utilities;

import com.moss.helper.file.FileHandler;

public class Settings {

    // application settings
    public final static String logFile = "helper.log";
    public final static String errorFile = "error.log";
    public final static boolean logMode = true;
    public final static boolean errorMode = true;

    // paths
    public final static String dataDirectory = FileHandler.workingDirectory + "\\data\\";
    public final static String documentsDirectory = dataDirectory + "documents\\";
    public final static String imagesDirectory = dataDirectory + "images\\";
    public final static String mostWantedDirectory = dataDirectory + "mostwanted\\";

    // files list
    public enum MostWanted {
        db
    }

    // documents extensions
    public enum DocumentExtensions {
        doc, docx, odt, pdf, ppt, pptx, rtf, txt
    }

    // images extensions
    public enum ImageExtensions {
        bmp, gif, jpg, png
    }
}
