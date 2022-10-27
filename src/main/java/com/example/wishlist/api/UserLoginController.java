package com.example.wishlist.api;

import com.example.wishlist.ents.User;
import com.example.wishlist.srvs.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping
    public String loginUserAccount(@ModelAttribute("user") User user) {
        if (userService.loginUser(user.getUserName(), user.getPassword())) {
            return "redirect:/login?success";
        } else {
            return "redirect:/login?error";
        }
    }
}
