package com.github.andriell.db;

import com.github.andriell.processor.db.ProcessDbDataInterface;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrey on 22.06.2016
 */
public class Product implements ProcessDbDataInterface {
    private int id;
    private String site;
    private String code;
    private String name;
    private String url;
    private float price;
    private String currency;
    private Date date = new Date();
    private Set<ProductProperty> property = new HashSet<ProductProperty>(0);
    private ProductDao productDao;
    private float priceDelta;

    public float getPriceDelta() {
        return (float) (Math.rint(100.0 * priceDelta) / 100.0);
    }

    public void setPriceDelta(float priceDelta) {
        this.priceDelta = (float) (Math.rint(100.0 * priceDelta) / 100.0);
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

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

    public float getPrice() {
        return (float) (Math.rint(100.0 * price) / 100.0);
    }

    public void setPrice(float price) {
        this.price = (float) (Math.rint(100.0 * price) / 100.0);
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

    public boolean addProperty(ProductProperty property) {
        property.setProduct(this);
        if ("price".equals(property.getName())) {
            price = property.getFloat();
            currency = property.getString();
        }
        return this.property.add(property);
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public boolean save() {
        return productDao.save(this);
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", site='" + site + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                ", property=" + property +
                ", productDao=" + productDao +
                '}';
    }
}
