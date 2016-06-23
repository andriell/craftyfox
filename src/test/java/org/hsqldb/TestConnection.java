package org.hsqldb;

import com.github.andriell.db.HibernateUtil;
import com.github.andriell.db.Product;
import com.github.andriell.db.Store;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rybalko on 21.06.2016.
 */
public class TestConnection {
    public static void main(String[] args) {
        Date today = Calendar.getInstance().getTime();
        System.out.println("Maven + Hibernate + MySQL");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        org.hibernate.Session session = sessionFactory.openSession();

        session.beginTransaction();
        Store stock = new Store();

        stock.setCode("4715");
        stock.setName("GENM");

        session.save(stock);
        session.getTransaction().commit();
        System.out.println("Store id: " + stock.getId());

        Product product = new Product();
        product.setCode(today.toString());
        session.save(product);
        System.out.println("Product id: " + product.getId());

        sessionFactory.close();
    }
}
