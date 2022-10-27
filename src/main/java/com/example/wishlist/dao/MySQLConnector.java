package com.example.wishlist.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceUtils;

import java.sql.*;

public class MySQLConnector {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String pass;
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wishingwell", "root", "root");
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return conn;
    }
}
