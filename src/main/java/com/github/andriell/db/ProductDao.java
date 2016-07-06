package com.github.andriell.db;

import org.hibernate.Criteria;

/**
 * Created by Rybalko on 23.06.2016.
 */
public interface ProductDao {
    public boolean save(Product product);
    public Criteria searchCriteria();
    public String[] searchFields();
}
