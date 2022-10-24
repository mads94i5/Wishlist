package com.example.wishlist.dao;

import com.example.wishlist.ents.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        return users;
    }
}
