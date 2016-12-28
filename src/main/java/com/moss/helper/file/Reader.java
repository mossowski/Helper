package com.moss.helper.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mossowsk
 * @since 28 gru 2016
 */
public class Reader {

    public static ArrayList<String> loadData(String pathName) {
        ArrayList<String> result = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = br.readLine();
            while (line != null) {
                result.add(line);
                line = br.readLine();
            }
        }
        catch (FileNotFoundException anException) {
            anException.printStackTrace();
        }
        catch (IOException anException) {
            anException.printStackTrace();
        }
        return result;
    }

}
