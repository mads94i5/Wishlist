package com.example.wishlist.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(){
    return "home/index";
  }
  @GetMapping("/error")
  public String error(){
    return "error";
  }
}
