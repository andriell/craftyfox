package com.github.andriell.db;

import java.sql.Date;

/**
 * Created by Andrey on 22.06.2016
 */
public class Product {
    private int id;
    private String code;
    private String name;
    private String url;
    private int price;
    private String currency;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
