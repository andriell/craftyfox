package com.github.andriell.db;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;

import java.util.List;
import java.util.Set;

/**
 * Created by Rybalko on 23.06.2016.
 */
public class ProductDaoImpl implements ProductDao {
    private static final Log LOG = LogFactory.getLog(ProductDaoImpl.class);
    private static final String PRICE = "price";

    private static final String[] fields = {
            "product.id",
            "product.site",
            "product.code",
            "product.name",
            "product.url",
            "product.price",
            "product.currency",
            "product.date",
            "property.name",
            "property.isArray",
            "property.integer",
            "property.float",
            "property.string",
            "property.text",
            "property.date",
    };
    private static final int[] fieldsType = {
            ProductDao.TYPE_INT,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_FLOAT,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_DATE,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_INT,
            ProductDao.TYPE_FLOAT,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_STRING,
            ProductDao.TYPE_DATE,
    };

    private SessionFactory sessionFactory;

    public Criteria searchCriteria() {
        return sessionFactory
                .openSession()
                .createCriteria(Product.class, "product")
                .createAlias("property", "property", JoinType.LEFT_OUTER_JOIN);
    }

    public Criteria countCriteria() {
        return searchCriteria().setProjection(Projections.countDistinct("product.id"));
    }

    public String[] searchFields() {
        return fields;
    }

    public int searchFieldsType(int i) {
        if (i > fieldsType.length) {
            return -1;
        }
        return fieldsType[i];
    }

    public Product findByCode(String code, Session session) {
        List<Product> products = session.createQuery("from Product where c_code=:code")
                .setParameter("code", code)
                .list();
        if (products.size() > 0) {
            return products.get(0);
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

    public float getLastPrice(int productId) {
        List<ProductProperty> products = getSessionFactory()
                .getCurrentSession()
                .createQuery("from ProductProperty where product_id=:product_id AND c_name=\"price\" order by date desc limit 1")
                .setParameter("product_id", productId)
                .list();
        if (products.size() > 0) {
            return products.get(0).getFloat();
        } else {
            return 0.0f;
        }
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
                if (PRICE.equals(property.getName()) && property.getFloat() == getLastPrice(product.getId())) {
                    Float newPrice = property.getFloat();
                    Float oldPrice = getLastPrice(product.getId());
                    if (oldPrice == newPrice) {
                        continue;
                    }
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
