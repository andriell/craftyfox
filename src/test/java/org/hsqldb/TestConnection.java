package org.hsqldb;

import com.github.andriell.db.Product;
import com.github.andriell.db.ProductProperty;
import com.github.andriell.db.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rybalko on 21.06.2016.
 */
public class TestConnection {
    public static void main(String[] args) {
        Date today = Calendar.getInstance().getTime();
        System.out.println("Maven + Hibernate + MySQL");

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        SessionFactory sessionFactory = applicationContext.getBean("sessionFactory", SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Store stock = new Store();

        stock.setCode("4715");
        stock.setName("GENM");

        session.save(stock);
        session.getTransaction().commit();
        System.out.println("Store id: " + stock.getId());

        Product product = new Product();
        product.setCode(today.toString());
        ProductProperty property = new ProductProperty();
        property.setName("property1");
        property.setInteger(100500);
        product.addProperty(property);
        session.save(product);
        System.out.println("Product id: " + product.getId());
        session.save(property);
        System.out.println("Product id: " + property.getId());

        sessionFactory.close();
    }
}
