package com.example.wishlist.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/index")
  public String home(){
    return "home/index";
  }
  @GetMapping("/error")
  public String error(){
    return "error";
  }
}
