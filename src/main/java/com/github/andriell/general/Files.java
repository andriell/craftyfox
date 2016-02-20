package com.github.andriell.general;

import java.io.*;

public class Files {
    public static final String DATA_DIR;
    public static final String CRAFT_DIR;
    public static final String DB_DIR;
    public static final String JS_DIR;

    static {
        DATA_DIR = System.getProperty("user.dir") + File.separator + "data";
        CRAFT_DIR = DATA_DIR + File.separator + "craft";
        DB_DIR = DATA_DIR + File.separator + "db";
        JS_DIR = DATA_DIR + File.separator + "js";
    }

    public static String readFile(File fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException ignored) { }
        return null;
    }

    public static void writeToFile(File fileName, String s) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            out.print(s);
            out.flush();
            out.close();
        } catch (FileNotFoundException ignored) { }
    }

    public static File[] readDir(String dir) {
        File folder = new File(dir);
        if (!folder.isDirectory()) {
            return null;
        }
        return folder.listFiles();
    }
}
