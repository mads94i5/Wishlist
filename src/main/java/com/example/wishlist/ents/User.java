package com.example.wishlist.ents;

import java.util.Collection;

public class User {
    private Long id;
    private String userName;
    private String password;
    private int wishlistId;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, int wishlistId) {
        this.userName = userName;
        this.password = password;
        this.wishlistId = wishlistId;
    }

    public User(Long id, String userName, String password, int wishlistId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.wishlistId = wishlistId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }
}
