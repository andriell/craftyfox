package com.github.andriell.db;

import com.github.andriell.general.Hash;

import java.util.Date;

/**
 * Created by Rybalko on 13.07.2016.
 */
public class HashDate {
    private Date date;
    private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = Hash.md5(hash);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
