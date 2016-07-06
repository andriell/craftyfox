package com.github.andriell.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by Rybalko on 23.06.2016.
 */
public class ProductDaoImpl implements ProductDao {
    private static final Log LOG = LogFactory.getLog(ProductDaoImpl.class);
    private static final String PRICE = "price";

    private SessionFactory sessionFactory;

    public Criteria createCriteria() {
        return sessionFactory.openSession().createCriteria(Product.class);
    }

    public Product findByCode(String code, Session session) {
        List<Product> users = session.createQuery("from Product where c_code=:code")
                .setParameter("code", code)
                .list();
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public int clearProperty(int productId, Session session) {
        return session.createQuery("delete from ProductProperty where c_name<>:name AND product_id = :product_id")
                .setParameter("name", PRICE)
                .setParameter("product_id", productId)
                .executeUpdate();
    }

    public List<ProductProperty> getProperty(int productId, String propertyName) {
        return getSessionFactory()
                .getCurrentSession()
                .createQuery("from ProductProperty where product_id=:product_id AND c_name=:name")
                .setParameter("product_id", productId)
                .setParameter("name", propertyName)
                .list();
    }

    public boolean save(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            Product productOld = findByCode(product.getCode(), session);
            if (productOld != null) {
                product.setId(productOld.getId());
                session.merge(product);
            } else {
                session.save(product);
            }
            clearProperty(product.getId(), session);
            Set<ProductProperty> properties = product.getProperty();
            for (ProductProperty property: properties) {
                if (PRICE.equals(property.getName()) && product.getPrice() == property.getFloat()) {
                    continue; // Если цена не изменилась, то ее не нужно обновлять
                }
                session.save(property);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            LOG.error(this, e);
            session.getTransaction().rollback();
            return false;
        }

        return true;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
