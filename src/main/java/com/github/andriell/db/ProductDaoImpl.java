package com.github.andriell.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by Rybalko on 23.06.2016.
 */
public class ProductDaoImpl implements ProductDao {
    private static final Log LOG = LogFactory.getLog(ProductDaoImpl.class);
    private SessionFactory sessionFactory;

    public Product findByCode(String code) {
        List<Product> users = getSessionFactory()
                .getCurrentSession()
                .createQuery("from Product where code=:code")
                .setParameter("code", code)
                .list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public boolean save(Product product) {
        Product p = findByCode(product.getCode());
        if (p != null) {
            product.setId(p.getId());
        }

        return true;
    }

    public boolean _save(Product product) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(product);
            Set<ProductProperty> properties = product.getProperty();
            for (ProductProperty property: properties) {
                session.save(property);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error(this, e);
            session.getTransaction().rollback();
            return false;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
