package org.hsqldb;

import com.github.andriell.db.HibernateUtil;
import com.github.andriell.db.Store;
import org.hibernate.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 21.06.2016.
 */
public class TestConnection {
    public static void main(String[] args) {
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
        sessionFactory.close();
    }
/*
    @Test
    public void test1() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        DataSource jdbcPool = applicationContext.getBean("dataSource", DataSource.class);
        Connection c1 = jdbcPool.getConnection();
        Connection c2 = jdbcPool.getConnection();
        assertEquals("Пустая строка", true, c1.equals(c2));

    }*/
}
