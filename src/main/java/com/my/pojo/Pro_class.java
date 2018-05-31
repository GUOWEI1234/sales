package com.my.pojo;

public class Pro_class {
  private String class_id;
  private String product_id;
  private Product product;
  private Class aClass;

  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }
  public Class getaClass() {
    return aClass;
  }
  public void setaClass(Class aClass) {
    this.aClass = aClass;
  }
  public String getClass_id() {
    return class_id;
  }

  public void setClass_id(String class_id) {
    this.class_id = class_id;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }
}
