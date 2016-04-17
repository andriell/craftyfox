package com.github.andriell.general;

import java.io.File;
import java.net.URI;

/**
 * Created by Vika on 17.04.2016
 */
public class FileData extends File {

    public FileData(String pathname) {
        super(Files.DATA_DIR + File.separator + pathname);
    }

    public FileData(String parent, String child) {
        super(Files.DATA_DIR + File.separator + parent, child);
    }

    public FileData(File parent, String child) {
        super(parent, child);
    }

    public FileData(URI uri) {
        super(uri);
    }
}
