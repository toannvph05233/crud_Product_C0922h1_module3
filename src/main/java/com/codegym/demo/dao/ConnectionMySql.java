package com.codegym.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/demo_jdbc_C0922h1";
        String jdbcUsername = "root";
        String jdbcPassword = "12345678";
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return connection;
    }
}
