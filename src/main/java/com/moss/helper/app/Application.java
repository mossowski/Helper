package com.moss.helper.app;

import com.moss.helper.file.FileHandler;
import static com.moss.helper.utilities.Settings.driveC;
import static com.moss.helper.utilities.Settings.skypeFile;

import java.io.File;

public class Application {

    public Application() {
        FileHandler.findFile(skypeFile, new File(driveC));
    }
}
