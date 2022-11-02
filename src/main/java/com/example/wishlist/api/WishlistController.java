package com.example.wishlist.api;

import com.example.wishlist.dao.WishlistRepository;
import com.example.wishlist.ents.Wish;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URL;
import java.net.http.HttpRequest;

@Controller
public class WishlistController {

  WishlistRepository wishlistRepository;

  public WishlistController(WishlistRepository w) {
    wishlistRepository = w;
  }


  @GetMapping("/wishlists")
  public String wishlist(Model model, HttpSession session){
    Long loginId = (Long) session.getAttribute("LOGIN_ID");
    if (loginId == null) {
      return "user/error";
    } else {
      model.addAttribute("LOGIN_ID", loginId);
      model.addAttribute("wishlists", wishlistRepository.showWishLists(loginId));

      return "wishlist/wishlists";
    }
  }

  @GetMapping("/wishlist/{id}")
  public String showWishlist(@PathVariable("id") Long id, Model model) {

    model.addAttribute("wishlist", wishlistRepository.showWishes(id));

    return "wishlist/wishlist";
  }

  @GetMapping("/create-wishlist")
  public String createWishList(HttpSession session) {
    Long loginId = (Long) session.getAttribute("LOGIN_ID");
    if (loginId == null) {
      return "user/error";
    } else {
    wishlistRepository.createWishlist(loginId);
    Long wishlistId = wishlistRepository.findNewWishList(loginId);
    return "redirect:/create-wish/" + wishlistId;
    }
  }

  @GetMapping("/create-wish/{id}")
  public String createWish(@PathVariable("id") Long id) {

    return "wishlist/create-wish";
  }

  @PostMapping("/create-wish/{id}")
  public String addWish(Model model, @PathVariable("id") Long id,
                              @RequestParam("item_description") String description,
                              @Nullable @RequestParam("item_price") double price,
                              @Nullable @RequestParam("item_url") String itemLink,
                              @Nullable @RequestParam("item_comment") String comment){

    Wish newWish = new Wish(description, price, itemLink, comment, false, id);
    model.addAttribute("wish", newWish);

    wishlistRepository.addWish(newWish, id);

    return "redirect:/wishlist/{id}";
  }

  @PostMapping("/wishlist/{id}")
  public String reserveWish(@PathVariable Long id, @RequestParam("reserved") boolean reserved, @RequestParam("id") Long wishId){

    wishlistRepository.reserveWish(wishId, reserved);

    return "redirect:/wishlist/{id}";
  }

}
