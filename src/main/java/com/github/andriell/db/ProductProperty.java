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
            integer = Integer.parseInt(s);
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

    private void price(int i, float f, String currency) {
        integer = i;
        aFloat = f;
        name = "price";
        isArray = null;
        if (date == null) {
            date = Calendar.getInstance().getTime();
        }
        setString(currency);
    }

    public ProductProperty price(Object price, String currency) {
        return price(price.toString(), currency);
    }

    public ProductProperty price(String price, String currency) {
        if (price == null) {
            return this;
        }
        price = price.trim();
        if (price.matches("^[\\+\\-]?\\d+$")) {
            int i = Integer.parseInt(price);
            price(i, (float) i, currency);
        } else if (price.matches("^[\\+\\-]?\\d+[\\.\\,]\\d+$")) {
            float f = Float.parseFloat(price);
            price(Math.round(f), f, currency);
        }
        return this;
    }

    public ProductProperty price(int price, String currency) {
        price(price, (float) price, currency);
        return this;
    }

    public ProductProperty price(float price, String currency) {
        price(Math.round(price), price, currency);
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
        if (string == null) {
            this.string = null;
        } else if (string.length() > 255) {
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

    public String getValue() {
        if ("price".equals(name)) {
            return Float.toString(aFloat) + " " + string + " " + FORMAT.format(date);
        } else if (text != null) {
            return text;
        } else if (string != null) {
            return string;
        } else if (date != null) {
            return FORMAT.format(date);
        } else if (aFloat != 0) {
            return Float.toString(aFloat);
        } else if (integer != 0) {
            return Integer.toString(integer);
        }
        return null;
    }

    public ProductProperty setValue(Object o) throws ParseException {
        return setValue(o.toString());
    }

    @Override
    public String toString() {
        return "ProductProperty{" +
                "id=" + id +
                ", productId=" + productId +
                ", isArray='" + isArray + '\'' +
                ", name='" + name + '\'' +
                ", integer=" + integer +
                ", aFloat=" + aFloat +
                ", string='" + string + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
