package com.example.wishlist.api;

import com.example.wishlist.dao.UserDto;
import com.example.wishlist.srvs.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping("/create-user")
  public String showCreateUser(Model model) {
    model.addAttribute("user", new UserDto());
    return "user/create-user";
  }

  @GetMapping("/login")
  public String login(){
    return "user/login";
  }

  @PostMapping
  public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
    userService.create(userDto);
    return "redirect:/register?success";
  }
}
