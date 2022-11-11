package com.example.wishlist.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class MySQLConnector {
    private static MySQLConnector instance;
    private Connection conn = null;
    // @Value does not work as intended on classes without Bean annotation like @Repository
    // @Value("${spring.datasource.url}")
    private final String url = System.getenv("spring.datasource.url");
    // @Value("${spring.datasource.username}")
    private final String user = System.getenv("spring.datasource.username");
    // @Value("${spring.datasource.password}")
    private final String pass = System.getenv("spring.datasource.password");

    public static MySQLConnector getInstance() {
        if (instance == null) {
            instance = new MySQLConnector();
        }
        return instance;
    }
    public Connection getConnection() {
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
