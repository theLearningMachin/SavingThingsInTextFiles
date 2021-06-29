package com.egovictoria.savingthingsintextfiles;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.IOException;

public class AppConstants {

    public static File saveDirectory;
    public static UnorderedDictionary dict;


    public static void initialize(Context c) throws IOException {
        File root = c.getFilesDir();
        saveDirectory = new File(root, "dictionary.txt");
        dict = new UnorderedDictionary(saveDirectory);
    }

}
