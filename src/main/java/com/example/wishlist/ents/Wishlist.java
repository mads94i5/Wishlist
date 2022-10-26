package com.example.wishlist.ents;

import java.util.Collection;

public class Wishlist {
    private Long id;

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
