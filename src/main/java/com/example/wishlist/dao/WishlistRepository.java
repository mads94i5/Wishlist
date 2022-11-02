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
    public Long findByUserId(Long userId) {

        Long foundId = null;
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "SELECT * FROM wishlists WHERE user_id=?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, userId);

            ResultSet rs = psts.executeQuery();

            rs.next();
            foundId = rs.getLong(1);

        } catch (SQLException e) {
            System.out.println("findByUserId: Cannot connect to database.");
            e.printStackTrace();
        }
        return foundId;
    }

    public List<Wishlist> showWishLists(Long id) {

        List<Wishlist> wishlists = new LinkedList<>();
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "select * from wishlists w " +
                "left join users u " +
                "on u.id = w.user_id " +
                "where u.id = ?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, id);

            ResultSet rs = psts.executeQuery();

            while (rs.next()){
                Long wId = rs.getLong(1);
                Long userId = rs.getLong(2);


                wishlists.add(new Wishlist(wId, userId));

            }
        } catch (SQLException e) {
            System.out.println("showWishLists: Cannot connect to database.");
            e.printStackTrace();
        }
        return wishlists;
    }

    public List<Wish> showWishes(Long wishListId) {

        List<Wish> wishlist = new LinkedList<>();
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "select * from wishes w " +
                "left join wishlists wl " +
                "on wl.id = w.wishlist_id " +
                "where wl.id = ?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, wishListId);

            ResultSet rs = psts.executeQuery();

            while (rs.next()){
                Long wishId = rs.getLong(1);
                String description = rs.getString(2);
                double price = rs.getDouble(3);
                String url = rs.getString(4);
                String comment = rs.getString(5);
                boolean reserved = rs.getBoolean(6);

                wishlist.add(new Wish(wishId, description, price, url, comment, reserved, wishListId));

            }
        } catch (SQLException e) {
            System.out.println("showWishes: Cannot connect to database.");
            e.printStackTrace();
        }
        return wishlist;
    }

    public void addWish(Wish wish, Long id){

        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "insert into wishes (item_description, price, url, item_comment, reserved, wishlist_id) " +
                "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setString(1, wish.getDescription());
            psts.setDouble(2, wish.getPrice());
            psts.setString(3, wish.getItemLink());
            psts.setString(4, wish.getComment());
            psts.setBoolean(5, wish.isReserved());
            psts.setLong(6, id);

            psts.executeUpdate();

        } catch (SQLException e) {
            System.out.println("addWish: Cannot connect to database.");
            e.printStackTrace();
        }
    }

    public void reserveWish(Long wishId, boolean reserved){

        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "update wishes " +
                "set reserved = ? " +
                "where id = ?";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setBoolean(1, reserved);
            psts.setLong(2, wishId);

            psts.executeUpdate();

        } catch (SQLException e) {
            System.out.println("reserveWish: Cannot connect to database.");
            e.printStackTrace();
        }
    }

    public void createWishlist(Long userId){

        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "insert into wishlists (user_id) " +
                "values(?);";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, userId);

            psts.executeUpdate();

        } catch (SQLException e) {
            System.out.println("createWishlist: Cannot connect to database.");
            e.printStackTrace();
        }
    }

    public Long findNewWishList(Long userId) {

        Long foundId = null;
        try {
            Connection conn = new MySQLConnector().getConnection();

            String query = "select id " +
                "from wishlists " +
                "where user_id = ? " +
                "order by id desc " +
                "LIMIT 1;";
            PreparedStatement psts = conn.prepareStatement(query);

            psts.setLong(1, userId);

            ResultSet rs = psts.executeQuery();

            rs.next();
            foundId = rs.getLong(1);

        } catch (SQLException e) {
            System.out.println("findNewWishList: Cannot connect to database.");
            e.printStackTrace();
        }
        return foundId;
    }

}
