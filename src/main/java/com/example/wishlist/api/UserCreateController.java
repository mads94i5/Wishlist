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
@RequestMapping("/create-user")
public class UserCreateController {

  private final UserService userService;

  public UserCreateController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping
  public String showCreateUser(Model model) {
    model.addAttribute("user", new User());
    return "user/create-user";
  }

  @PostMapping
  public String registerUserAccount(@ModelAttribute("user") User user) {
    userService.create(user);
    return "redirect:/create-user?success";
  }



}
