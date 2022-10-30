package com.example.wishlist.api;

import com.example.wishlist.dao.WishlistRepository;
import com.example.wishlist.ents.Wish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URL;

@Controller
public class WishlistController {

  WishlistRepository wishlistRepository;

  public WishlistController(WishlistRepository w) {
    wishlistRepository = w;
  }

  //Nedenstående skal  metode slettes, kun tilføjet for at kunne se om tabel virkede.
  @GetMapping("/wishlist")
  public String wishlist() {
    return "wishlist/wishlist";
  }

  @GetMapping("/wishlist/{id}")
  public String showWishlist(@PathVariable("id") Long id, Model model) {
    model.addAttribute("wishlist", wishlistRepository.showWishList(id));
    return "wishlist/wishlist";
  }

  @GetMapping("/create-wishlist")
  public String createWishList() {
    return "wishlist/create-wishlist";
  }

  @PostMapping("/create-wishlist")
  public String addWish(@PathVariable("id") Long id,
                              @RequestParam("Description") String description,
                              @RequestParam("Price") double price,
                              @RequestParam("URL") URL itemLink,
                              @RequestParam("Comment") String comment,
                              @RequestParam("Reserved") boolean reserved) {

    Wish newWish = new Wish(description, price, itemLink, comment, reserved, id);

    wishlistRepository.addWish(newWish, id);

    return "redirect:/wishlist/{id}";
  }

}
