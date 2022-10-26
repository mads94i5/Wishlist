package com.example.wishlist.api;

import com.example.wishlist.dao.WishlistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WishlistController {

  WishlistRepository wishlistRepository;
  public WishlistController(WishlistRepository w) {
    wishlistRepository = w;
  }
  @GetMapping("/wishlist/{id}")
  public String showWishlist(@PathVariable("id") Long id, Model model) {
    model.addAttribute("wishlist", wishlistRepository.findById(id));
    return "wishlist/wishlist";
  }

@GetMapping("/create-wishlist")
  public String createWishList() {
    return "wishlist/create-wishlist";
  }
}
