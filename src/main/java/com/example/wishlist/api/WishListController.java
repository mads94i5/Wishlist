package com.example.wishlist.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WishListController {
  @GetMapping("/wishlist")
  public String wishlist(){
    return "wishlist/wishlist";
  }

@GetMapping("/create-wishlist")
  public String createWishList(){
    return "wishlist/create-wishlist";
  }
}
