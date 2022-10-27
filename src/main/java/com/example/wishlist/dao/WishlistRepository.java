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

        //Wishlist foundWishlist = new Wishlist();
        //foundWishlist.setId(id);
        List<Wish> wishlist = new LinkedList<>();
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "use wishingwell;\n" +
                "select w.id, w.item_description, w.price, w.url, w.item_comment, w.reserved\n" +
                "from users u\n" +
                "left join wishes w\n" +
                "on u.wishlist_id = w.wishlist_id id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, id);

            ResultSet rs = psts.executeQuery();

            while (rs.next()){
                Long wId = rs.getLong(1);
                String description = rs.getString(2);
                double price = rs.getDouble(3);
                URL url = rs.getURL(4);
                String comment = rs.getString(5);
                boolean reserved = rs.getBoolean(6);

                wishlist.add(new Wish(wId, description, price, url, comment, reserved, id));

            }
        } catch (SQLException e) {
            System.out.println("Cannot connect to database.");
            e.printStackTrace();
        }
        return wishlist;
    }
}
