package com.example.wishlist.dao;

import com.example.wishlist.ents.Role;
import com.example.wishlist.ents.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class UserRepository {

    @Value("${spring.datasource.url}")
    private String db_url;
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = new MySQLConnector().getConnection();

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                int wishlistId = resultSet.getInt(4);
                Collection<Role> roles = (Collection<Role>) new Role(resultSet.getString(5));
                users.add(new User(id, userName, password, wishlistId));
            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return users;
    }
    public User findByUserName(String searchUserName) {
        User user = new User();
        try {
            // Connection conn = new MySQLConnector().getConnection();
            Connection conn = DriverManager.getConnection(db_url, "root", "test");

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users WHERE user_name=?");

            psts.setString(1, searchUserName);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                int wishlistId = resultSet.getInt(4);
                Collection<Role> roles = (Collection<Role>) new Role(resultSet.getString(5));
                user = new User(id, userName, password, wishlistId);
            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return user;
    }
    public User create(User newUser) {
        try {
            // Connection conn = new MySQLConnector().getConnection();
            Connection conn = DriverManager.getConnection(db_url, "root", "test");

            String query = "INSERT INTO users (user_name, user_password) VALUES (?, ?)";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, newUser.getUserName());
            psts.setString(2, newUser.getPassword());

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return newUser;
    }
    public void update(User user) {
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "UPDATE users " +
                    "SET user_name=?, user_password=?, wishlist_id=? WHERE id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, user.getUserName());
            psts.setString(2, user.getPassword());
            psts.setInt(3, user.getWishlistId());
            psts.setLong(4, user.getId());

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setInt(1, id);

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
    }
}
