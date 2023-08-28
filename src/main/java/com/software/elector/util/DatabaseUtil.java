package com.software.elector.util;

import com.software.elector.enums.ProcessErrorMessage;
import com.software.elector.exception.DatabaseAccessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author C.Mateo
 */
public class DatabaseUtil {

    
    private final static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(PropertiesUtil.getProperty("db.url"));
        dataSource.setUsername(PropertiesUtil.getProperty("db.user"));
        dataSource.setPassword(PropertiesUtil.getProperty("db.password"));
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);
    }

    public static BasicDataSource getDataSource() {
        return dataSource;
    }
  
    
    /*
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
            throw new DatabaseAccessException("Error la conectar con la base de datos");
        }

        return connection;
    }
    
    */
    public static int getLastInsertId(ResultSet generatedKeys) throws SQLException {
        if (generatedKeys.next()) {
            int generatedId;
            generatedId = generatedKeys.getInt(1);
            return generatedId;
        } else {
            throw new DatabaseAccessException("Error al obtener el id de la entidad insertada!");
        }
    }

}
