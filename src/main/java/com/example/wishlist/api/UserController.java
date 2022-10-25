package com.example.wishlist.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @GetMapping("user/create-user")
  public String createUser(){
    return "user/create-user";
  }

  @GetMapping("user/login")
  public String login(){
    return "user/login";
  }
}
