package com.example.wishlist.api;

import com.example.wishlist.dao.UserDto;
import com.example.wishlist.srvs.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showLogin() {
        return "user/login";
    }

    @PostMapping
    public String loginUserAccount(@ModelAttribute("user") UserDto userDto) {
        userService.loadUserByUsername(userDto.getUserName());
        return "redirect:/";
    }
}