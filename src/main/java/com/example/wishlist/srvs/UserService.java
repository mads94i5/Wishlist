package com.example.wishlist.srvs;

import com.example.wishlist.ents.User;

public interface UserService {
    User create(User user);
    boolean loginUser(String userName, String password);
    User findUserById(String id);
    Long findIdByUser(User user);
    String findUserNameById(String id);
}
