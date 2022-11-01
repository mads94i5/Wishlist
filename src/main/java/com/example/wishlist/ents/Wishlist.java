package com.example.wishlist.ents;

public class Wishlist {
    private Long id;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Wishlist(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Wishlist() {
    }

    public Wishlist(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
