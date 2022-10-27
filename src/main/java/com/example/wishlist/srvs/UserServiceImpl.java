package com.example.wishlist.srvs;

import com.example.wishlist.dao.UserDto;
import com.example.wishlist.dao.UserRepository;
import com.example.wishlist.ents.Role;
import com.example.wishlist.ents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encryption = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(UserDto userDto) {
        User user = new User(userDto.getUserName(),
                encryption.encode(userDto.getPassword()));
        return userRepo.create(user);
    }

    @Override
    public boolean loginUser(String userName, String password) {
        List<User> users = userRepo.getAll();
        for (User user : users) {
            if ((userName.equals(user.getUserName())) && (encryption.encode(password).equals(user.getPassword()))) {
                return true;
            }
        }
        return false;
    }
}
