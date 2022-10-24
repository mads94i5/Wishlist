package com.example.wishlist.dao;

import com.example.wishlist.ents.User;
import com.example.wishlist.ents.Wishlist;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection conn = new Connector().getConnection();

            PreparedStatement psts = conn.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = psts.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String userName = resultSet.getString(2);
                String password = resultSet.getString(3);
                int wishlistId = resultSet.getInt(4);
                users.add(new User(id, userName, password, wishlistId));
            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return users;
    }
    public void create(User newUser) {
        try {
            Connection conn = new Connector().getConnection();

            String query = "INSERT INTO users (user_name, password, wishlist_id) VALUES (?, ?, ?)";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, newUser.getUserName());
            psts.setString(2, newUser.getPassword());
            psts.setInt(3, newUser.getWishlistId());

            psts.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
    }
    public void update(User user) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokedex", "root", "test");

            String query = "UPDATE users " +
                    "SET user_name=?, password=?, wishlist_id=? WHERE id=?";
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
}
