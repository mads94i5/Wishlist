package com.example.wishlist.api;

import com.example.wishlist.ents.User;
import com.example.wishlist.srvs.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class UserLoginController {

    private final UserService userService;


    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showLogin(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        User loggedInUser = (User) session.getAttribute("logged-in");
        if (loggedInUser == null) {
            loggedInUser = new User();
        }
        model.addAttribute("logged-in", loggedInUser);
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping
    public String loginUserAccount(@ModelAttribute("user") User user, HttpSession session, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        User loggedInUser = (User) request.getSession().getAttribute("logged-in");
        if (loggedInUser == null) {
            if (userService.loginUser(user.getUserName(), user.getPassword())) {
                request.getSession().setAttribute("logged-in", user);
                return "redirect:/login?success";
            } else {
                return "redirect:/login?error";
            }
        } else {
            return "redirect:/login?logged-in";
        }
    }
}
