package com.github.andriell.processor.csv;

import com.github.andriell.general.FileData;

import java.io.File;

/**
 * Created by Rybalko on 17.06.2016.
 */
public class ProcessCsvData {
    private File file;
    private String[] collection;

    public ProcessCsvData(int size) {
        collection = new String[size];
    }

    public void file(String file) {
        this.file = new FileData(file + ".csv");
    }

    private void add(int position, String s) {
        collection[position] = s;
    }
}
