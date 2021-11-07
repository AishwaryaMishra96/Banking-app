package com.niit.idbcbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static Connection connection;

    public static Connection getConnection() {
        String URL = "jdbc:mysql://localhost:3306/idbc_bank";
        String username = "root";
        String password = "aish@123";
        try {
            connection = DriverManager.getConnection(URL, username, password);
            return connection;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
