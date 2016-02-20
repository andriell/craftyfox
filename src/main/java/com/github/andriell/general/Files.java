package com.github.andriell.general;

import java.io.File;

public class Files {
    public static final String DATA_DIR;
    public static final String CRAFT_DIR;
    public static final String DB_DIR;

    static {
        DATA_DIR = System.getProperty("user.dir") + File.separator + "data";
        CRAFT_DIR = DATA_DIR + File.separator + "craft";
        DB_DIR = DATA_DIR + File.separator + "db";
    }
}
