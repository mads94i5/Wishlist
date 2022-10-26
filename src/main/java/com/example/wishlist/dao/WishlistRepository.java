package com.example.wishlist.dao;

import com.example.wishlist.ents.Wishlist;
import org.springframework.stereotype.Repository;

import java.sql.*;

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
}
