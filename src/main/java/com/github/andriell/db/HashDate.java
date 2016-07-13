package com.github.andriell.db;

import org.springframework.util.DigestUtils;

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

    public void setHash(String str) {
        hash = DigestUtils.md5DigestAsHex(str.getBytes());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
