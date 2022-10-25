package com.example.wishlist.api;

import org.springframework.stereotype.Controller;

@Controller
public class WishListController {

  public String createWishList(){
    return "createWishList";
  }
}
