package com.github.andriell.db;

import org.springframework.util.DigestUtils;

/**
 * Created by Rybalko on 13.07.2016.
 */
public class HashDate {
    private long date;
    private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String str) {
        hash = str;
    }

    public void setString(String str) {
        hash = DigestUtils.md5DigestAsHex(str.getBytes());
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
