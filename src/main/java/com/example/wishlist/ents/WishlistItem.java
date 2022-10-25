package com.example.wishlist.ents;

import java.net.URL;

public class WishlistItem {

  private String description;
  private double price;
  private URL itemLink;
  private String comment;
  private boolean reserved;


  public WishlistItem(String description, double price, URL itemLink, String comment, boolean reserved) {
    this.description = description;
    this.price = price;
    this.itemLink = itemLink;
    this.comment = comment;
    this.reserved = reserved;
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
}
