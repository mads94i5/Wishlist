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
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLogin(Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        Long loginId = (Long) session.getAttribute("LOGIN_ID");

        model.addAttribute("LOGIN_ID", loginId);
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/login")
    public String loginUserAccount(@ModelAttribute("user") User user, HttpServletRequest request) {
        @SuppressWarnings("unchecked")
        Long loginId = (Long) request.getSession().getAttribute("LOGIN_ID");
        if (loginId == null) {
            if (userService.loginUser(user.getUserName(), user.getPassword())) {
                request.getSession().setAttribute("LOGIN_ID", userService.findIdByUser(user));
                return "redirect:/login?success";
            } else {
                return "redirect:/login?error";
            }
        } else {
            return "redirect:/login?loggedin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
