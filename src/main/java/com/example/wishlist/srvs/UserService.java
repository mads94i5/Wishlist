package com.example.wishlist.srvs;

import com.example.wishlist.dao.UserDto;
import com.example.wishlist.ents.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User create(UserDto userDto);
}
