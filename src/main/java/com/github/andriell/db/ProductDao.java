package com.github.andriell.db;

import org.hibernate.Criteria;

/**
 * Created by Rybalko on 23.06.2016.
 */
public interface ProductDao {
    public final int TYPE_INT = 1;
    public final int TYPE_FLOAT = 2;
    public final int TYPE_DATE = 3;
    public final int TYPE_STRING = 4;

    public Product getById(int id);
    public boolean save(Product product);
    public Criteria searchCriteria();
    public Criteria countCriteria();
    public String[] searchFields();
    public int searchFieldsType(int i);
}
