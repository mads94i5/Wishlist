package com.example.wishlist.srvs;

import com.example.wishlist.dao.UserDto;
import com.example.wishlist.ents.User;

public interface UserService {
    User create(UserDto userDto);

    boolean loginUser(String userName, String password);
}
