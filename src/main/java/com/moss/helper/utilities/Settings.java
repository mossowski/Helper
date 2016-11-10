package com.moss.helper.utilities;

import com.moss.helper.file.FileHandler;

public class Settings {

    // application settings
    public final static String logFile = "helper.log";
    public final static String errorFile = "error.log";
    public final static boolean logMode = true;
    public final static boolean errorMode = true;

    // paths
    public final static String driveC = "C:\\";

    // files list
    public final static String skypeFile = "main.db";

    // data list
    public final static String dataDirectory = FileHandler.workingDirectory + "\\data\\";
}
