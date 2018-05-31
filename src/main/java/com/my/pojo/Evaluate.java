package com.my.pojo;

public class Evaluate {
  private String user_id;
  private String product_id;
  private java.sql.Timestamp eva_time;
  private String evalate;

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

  public java.sql.Timestamp getEva_time() {
    return eva_time;
  }

  public void setEva_time(java.sql.Timestamp eva_time) {
    this.eva_time = eva_time;
  }

  public String getEvalate() {
    return evalate;
  }

  public void setEvalate(String evalate) {
    this.evalate = evalate;
  }
}
