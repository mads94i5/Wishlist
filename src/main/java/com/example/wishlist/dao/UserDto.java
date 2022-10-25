package com.example.wishlist.dao;

public class UserDto {
    private String userName;
    private String password;
    private int wishlistId;

    public UserDto() {
    }

    public UserDto(String userName, String password, int wishlistId) {
        this.userName = userName;
        this.password = password;
        this.wishlistId = wishlistId;
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
