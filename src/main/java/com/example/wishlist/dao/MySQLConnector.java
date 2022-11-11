package com.example.wishlist.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class MySQLConnector {
    private static MySQLConnector instance;
    private Connection conn;
    // private final String url = System.getenv("spring.datasource.url");
    // private final String user = System.getenv("spring.datasource.username");
    // private final String pass = System.getenv("spring.datasource.password");

    public static MySQLConnector getInstance() {
        if (instance == null) {
            instance = new MySQLConnector();
        }
        return instance;
    }
    public Connection getConnection(String url, String user, String pass) {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("MySQLConnector: Cannot connect to database.");
                e.printStackTrace();
            }
        }
        return conn;
    }
}
