package com.my.pojo;

import java.util.List;

public class Product {
  private String product_id;
  private String product_name;
  private String product_price;
  private String product_intr;
  private Long product_count;
  private String product_statu;
  private List<Pro_img> pro_img;
  private Class aClass;

  public Class getaClass() {
    return aClass;
  }

  public void setaClass(Class aClass) {
    this.aClass = aClass;
  }

  public List<Pro_img> getPro_img() {
    return pro_img;
  }

  public void setPro_img(List<Pro_img> pro_img) {
    this.pro_img = pro_img;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getProduct_price() {
    return product_price;
  }

  public void setProduct_price(String product_price) {
    this.product_price = product_price;
  }

  public String getProduct_intr() {
    return product_intr;
  }

  public void setProduct_intr(String product_intr) {
    this.product_intr = product_intr;
  }

  public Long getProduct_count() {
    return product_count;
  }

  public void setProduct_count(Long product_count) {
    this.product_count = product_count;
  }

  public String getProduct_statu() {
    return product_statu;
  }

  public void setProduct_statu(String product_statu) {
    this.product_statu = product_statu;
  }
}
