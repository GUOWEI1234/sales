package com.my.pojo;

public class User {
  private String user_id;
  private String user_password;
  private String user_name;
  private String user_telphone;
  private Buy buy;
  private Product product;


  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Buy getBuy() {
    return buy;
  }

  public void setBuy(Buy buy) {
    this.buy = buy;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getUser_password() {
    return user_password;
  }

  public void setUser_password(String user_password) {
    this.user_password = user_password;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getUser_telphone() {
    return user_telphone;
  }

  public void setUser_telphone(String user_telphone) {
    this.user_telphone = user_telphone;
  }
}
