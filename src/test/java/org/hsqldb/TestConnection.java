package org.hsqldb;

import org.hsqldb.jdbc.JDBCPool;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rybalko on 21.06.2016.
 */
public class TestConnection {
    @Test
    public void test1() throws SQLException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        // Без этого событие destroy для бинов не будет вызвано
        applicationContext.registerShutdownHook();
        JDBCPool jdbcPool = applicationContext.getBean("db-connection-pool", JDBCPool.class);
        Connection c1 = jdbcPool.getConnection();
        Connection c2 = jdbcPool.getConnection();
        assertEquals("Пустая строка", true, c1.equals(c2));
    }
}
