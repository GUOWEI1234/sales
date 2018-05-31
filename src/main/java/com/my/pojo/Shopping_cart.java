package com.my.pojo;

public class Shopping_cart {
  private String user_id;
  private String product_id;
  private String pro_name;
  private String pro_price;
  private java.sql.Timestamp add_time;

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

  public String getPro_name() {
    return pro_name;
  }

  public void setPro_name(String pro_name) {
    this.pro_name = pro_name;
  }

  public String getPro_price() {
    return pro_price;
  }

  public void setPro_price(String pro_price) {
    this.pro_price = pro_price;
  }

  public java.sql.Timestamp getAdd_time() {
    return add_time;
  }

  public void setAdd_time(java.sql.Timestamp add_time) {
    this.add_time = add_time;
  }
}
