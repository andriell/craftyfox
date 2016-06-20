package com.github.andriell.nashorn.console;

import com.github.andriell.general.Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Rybalko on 20.06.2016.
 */
public class DataFileWriter {
    private BufferedWriter writer;

    public void init(String pathname) throws IOException {
        init(pathname, 8192);
    }

    public void init(String pathname, int sz) throws IOException {
        if ("/".equals(File.separator)) {
            pathname = pathname.replace("\\", File.separator);
        } else {
            pathname = pathname.replace("/", File.separator);
        }
        writer = new BufferedWriter(new FileWriter(Files.DATA_DIR + File.separator + pathname), sz);
    }


    public void write(int c) throws IOException {
        writer.write(Integer.toString(c));
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        writer.write(cbuf, off, len);
    }


    public void write(String s, int off, int len) throws IOException {
        writer.write(s, off, len);
    }


    public void newLine() throws IOException {
        writer.newLine();
    }


    public void flush() throws IOException {
        writer.flush();
    }

    public void close() throws IOException {
        writer.close();
    }
}
