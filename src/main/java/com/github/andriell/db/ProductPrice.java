package com.github.andriell.db;

import java.sql.Date;

/**
 * Created by Andrey on 22.06.2016
 */
public class ProductPrice {
    private int productId;
    private int price;
    private String currency;
    private Date date;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
}
