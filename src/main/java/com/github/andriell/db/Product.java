package com.github.andriell.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Date date = new Date();
    private Set<ProductProperty> property = new HashSet<ProductProperty>(0);

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ProductProperty> getProperty() {
        return property;
    }

    public void setProperty(Set<ProductProperty> property) {
        this.property = property;
    }

    public boolean setProperty(ProductProperty property) {
        return this.property.add(property);
    }
}
