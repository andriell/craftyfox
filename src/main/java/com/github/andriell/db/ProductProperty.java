package com.github.andriell.db;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Andrey on 22.06.2016
 */
public class ProductProperty {
    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    private int id;
    private int productId;
    private String isArray = "N";
    private String name;
    private int integer;
    private float aFloat;
    private String string;
    private String text;
    private Date date;
    private Product product;

    public ProductProperty() {}

    public ProductProperty(String name, int integer) {
        this.name = name;
        this.integer = integer;
    }

    public ProductProperty(String name, float aFloat) {
        this.name = name;
        this.aFloat = aFloat;
    }

    public ProductProperty(String name, String string) {
        this.name = name;
        setString(string);
    }

    public ProductProperty(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public ProductProperty setValue(int i) {
        integer = i;
        return this;
    }

    public ProductProperty setValue(float f) {
        aFloat = f;
        return this;
    }

    public ProductProperty setValue(Date d) {
        date = d;
        return this;
    }

    public ProductProperty setValue(String s) throws ParseException {
        if (s.length() > 255) {
            text = s;
            return this;
        }
        s = s.trim();
        if (s.matches("^[\\+\\-]?\\d+$")) {
            integer = Integer.getInteger(s);
            return this;
        }
        if (s.matches("^[\\+\\-]?\\d+[\\.\\,]\\d+$")) {
            aFloat = Float.parseFloat(s);
            return this;
        }
        if (s.matches("^\\d{4}\\-\\d{2}\\-\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
            date = FORMAT.parse(s);
            return this;
        }
        setString(s);
        return this;
    }

    public ProductProperty setValue(Object o) throws ParseException {
        return setValue(o.toString());
    }

    public ProductProperty price(float price) {
        price(price, null);
        return this;
    }

    public ProductProperty price(float price, String currency) {
        name = "price";
        isArray = null;
        if (date == null) {
            date = Calendar.getInstance().getTime();
        }
        aFloat = price;
        integer = Math.round(price);
        setString(currency);
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getIsArray() {
        return isArray;
    }

    public void setIsArray(String isArray) {
        this.isArray = isArray;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public float getFloat() {
        return aFloat;
    }

    public void setFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        if (string.length() > 255) {
            this.string = string.substring(0, 255);
        } else {
            this.string = string;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
