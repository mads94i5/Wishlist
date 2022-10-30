package com.example.wishlist.dao;

import com.example.wishlist.ents.Wish;
import com.example.wishlist.ents.Wishlist;
import org.springframework.stereotype.Repository;

import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class WishlistRepository {
    public Wishlist findById(Long id) {
        Wishlist foundWishlist = new Wishlist();
        foundWishlist.setId(id);
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "SELECT * FROM wishlists WHERE id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, id);

            ResultSet rs = psts.executeQuery();

            rs.next();
            Long foundId = rs.getLong(1);

            foundWishlist.setId(foundId);

        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return foundWishlist;
    }

    public List<Wish> showWishList(Long id) {

        List<Wish> wishlist = new LinkedList<>();
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "select * from wishes w " +
                "left join users u " +
                "on u.wishlist_id = w.wishlist_id " +
                "where u.wishlist_id = ?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, id);

            ResultSet rs = psts.executeQuery();

            while (rs.next()){
                String description = rs.getString(1);
                double price = rs.getDouble(2);
                URL url = rs.getURL(3);
                String comment = rs.getString(4);
                boolean reserved = rs.getBoolean(5);

                wishlist.add(new Wish(description, price, url, comment, reserved, id));

            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return wishlist;
    }

    public void addWish(Wish wish, Long id){

        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "insert into wishes (item_description, price, url, item_comment, wishlist_id) " +
                "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, wish.getDescription());
            psts.setDouble(2, wish.getPrice());
            psts.setURL(3, wish.getItemLink());
            psts.setString(4, wish.getComment());
            psts.setLong(5, id);

            psts.executeQuery();

        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
    }
}
