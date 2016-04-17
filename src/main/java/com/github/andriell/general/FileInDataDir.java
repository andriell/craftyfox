package com.github.andriell.general;

import java.io.File;
import java.net.URI;

/**
 * Created by Vika on 17.04.2016
 */
public class FileInDataDir extends File {

    public FileInDataDir(String pathname) {
        super(Files.DATA_DIR + File.separator + pathname);
    }

    public FileInDataDir(String parent, String child) {
        super(Files.DATA_DIR + File.separator + parent, child);
    }

    public FileInDataDir(File parent, String child) {
        super(parent, child);
    }

    public FileInDataDir(URI uri) {
        super(uri);
    }
}
