package com.example.wishlist.ents;

import java.net.URL;

public class WishlistItem {

  private Long itemId;
  private String description;
  private double price;
  private URL itemLink;
  private String comment;
  private boolean reserved;

  private Long wishListId;


  public WishlistItem(Long itemId, String description, double price, URL itemLink, String comment, boolean reserved, Long wishListId) {
    this.itemId = itemId;
    this.description = description;
    this.price = price;
    this.itemLink = itemLink;
    this.comment = comment;
    this.reserved = reserved;
    this.wishListId = wishListId;
  }

  public WishlistItem() {
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public URL getItemLink() {
    return itemLink;
  }

  public void setItemLink(URL itemLink) {
    this.itemLink = itemLink;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public boolean isReserved() {
    return reserved;
  }

  public void setReserved(boolean reserved) {
    this.reserved = reserved;
  }

  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public Long getWishListId() {
    return wishListId;
  }

  public void setWishListId(Long wishListId) {
    this.wishListId = wishListId;
  }
}
