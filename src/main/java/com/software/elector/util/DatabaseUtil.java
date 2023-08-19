package com.software.elector.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author C.Mateo
 */
public class DatabaseUtil {

    private static Connection connection;

    private DatabaseUtil() {

    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                String url = PropertiesUtil.getProperty("db.url");
                String user = PropertiesUtil.getProperty("db.user");
                String password = PropertiesUtil.getProperty("db.password");
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
        }
        return connection;
    }
}
