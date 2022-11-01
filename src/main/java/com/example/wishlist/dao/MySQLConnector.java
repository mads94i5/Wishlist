package com.example.wishlist.dao;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

public class MySQLConnector {
    // @Value does not work as intended on classes without Bean annotation like @Repository
    // @Value("${spring.datasource.url}")
    private String url = System.getenv("spring.datasource.url");
    // @Value("${spring.datasource.username}")
    private String user = System.getenv("spring.datasource.username");
    // @Value("${spring.datasource.password}")
    private String pass = System.getenv("spring.datasource.password");
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("MySQLConnector: Cannot connect to database.");
            e.printStackTrace();
        }
        return conn;
    }
}
