package com.example.wishlist.ents;

import java.net.URL;

public class Wish {
  private Long id;
  private String description;
  private double price;
  private URL itemLink;
  private String comment;
  private boolean reserved;
  private Long wishListId;

  public Wish(Long id, String description, double price, URL itemLink, String comment, boolean reserved, Long wishListId) {
    this.id = id;
    this.description = description;
    this.price = price;
    this.itemLink = itemLink;
    this.comment = comment;
    this.reserved = reserved;
    this.wishListId = wishListId;
  }

  public Wish() {
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getWishListId() {
    return wishListId;
  }

  public void setWishListId(Long wishListId) {
    this.wishListId = wishListId;
  }
}
