package com.example.wishlist.srvs;

import com.example.wishlist.dao.UserRepository;
import com.example.wishlist.ents.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encryption = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {
        User newUser = new User(user.getUserName(), encryption.encode(user.getPassword()));
        return userRepo.create(newUser);
    }

    @Override
    public boolean loginUser(String userName, String password) {
        List<User> users = userRepo.getAll();
        for (User user : users) {
            if ((userName.equals(user.getUserName())) && (encryption.matches(password, user.getPassword()))) {
                return true;
            }
        }
        return false;
    }
}
