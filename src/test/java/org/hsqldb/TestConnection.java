package org.hsqldb;

import com.github.andriell.general.Files;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Rybalko on 21.06.2016.
 */
public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String connectionString = "jdbc:hsqldb:file:" + Files.DB_DIR + File.separator + "testdb";
        System.out.println(connectionString);
        Connection c = DriverManager.getConnection(connectionString, "SA", "");
    }
}
