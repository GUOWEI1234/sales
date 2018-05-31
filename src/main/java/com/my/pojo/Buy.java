package com.my.pojo;

public class Buy {
  private Double buy_price;
  private String user_id;
  private String product_id;
  private String buy_count;
  private java.sql.Timestamp buy_time;

  public Double getBuy_price() {
    return buy_price;
  }

  public void setBuy_price(Double buy_price) {
    this.buy_price = buy_price;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getBuy_count() {
    return buy_count;
  }

  public void setBuy_count(String buy_count) {
    this.buy_count = buy_count;
  }

  public java.sql.Timestamp getBuy_time() {
    return buy_time;
  }

  public void setBuy_time(java.sql.Timestamp buy_time) {
    this.buy_time = buy_time;
  }
}
