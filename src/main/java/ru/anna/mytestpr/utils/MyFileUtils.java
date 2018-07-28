package ru.anna.mytestpr.utils;


import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class MyFileUtils {

    public static String scriptLoader (String fileName)  {
        try {
            return IOUtils.toString(MyFileUtils.class.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
