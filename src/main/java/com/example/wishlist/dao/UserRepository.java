package com.example.wishlist.dao;

import com.example.wishlist.ents.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                users.add(new User(id, userName, password));
            }
        } catch (SQLException e) {
            System.out.println("getAllUsers: Cannot connect to database.");
            e.printStackTrace();
        }
        return users;
    }

    public Long findIdByUser(User user) {
        Long userId = null;
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users WHERE user_name=?");

            psts.setString(1, user.getUserName());

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                userId = resultSet.getLong(1);
            }
        } catch (SQLException e) {
            System.out.println("findIdByUser: Cannot connect to database.");
            e.printStackTrace();
        }
        return userId;
    }
    public User findUserById(String userId) {
        User user = new User();
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users WHERE id=?");

            psts.setString(1, userId);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                user = new User(id, userName, password);
            }
        } catch (SQLException e) {
            System.out.println("findUserById: Cannot connect to database.");
            e.printStackTrace();
        }
        return user;
    }
    public String findUserNameById(String userId) {
        String userName = "";
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users WHERE id=?");

            psts.setString(1, userId);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                userName = resultSet.getString(2);
            }
        } catch (SQLException e) {
            System.out.println("findUserNameById: Cannot connect to database.");
            e.printStackTrace();
        }
        return userName;
    }
    public User findUserByUserName(String searchUserName) {
        User user = new User();
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users WHERE user_name=?");

            psts.setString(1, searchUserName);

            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                user = new User(id, userName, password);
            }
        } catch (SQLException e) {
            System.out.println("findUserByUserName: Cannot connect to database.");
            e.printStackTrace();
        }
        return user;
    }
    public User createUser(User newUser) {
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            String query = "INSERT INTO users (user_name, user_password) VALUES (?, ?)";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, newUser.getUserName());
            psts.setString(2, newUser.getPassword());

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("createUser: Cannot connect to database.");
            e.printStackTrace();
        }
        return newUser;
    }
    public void updateUser(User user) {
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            String query = "UPDATE users " +
                    "SET user_name=?, user_password=? WHERE id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, user.getUserName());
            psts.setString(2, user.getPassword());
            psts.setLong(3, user.getId());

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateUser: Cannot connect to database.");
            e.printStackTrace();
        }
    }

    public void deleteUserById(int id) {
        try {
            Connection conn = MySQLConnector.getInstance().getConnection(url, username, password);

            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setInt(1, id);

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("deleteUserById: Cannot connect to database.");
            e.printStackTrace();
        }
    }
}
