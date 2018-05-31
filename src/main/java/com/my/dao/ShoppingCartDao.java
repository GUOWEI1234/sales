package com.my.dao;

import com.my.pojo.Shopping_cart;

import java.util.List;

/**
 * 购物车
 * @author GUOwei
 * Created by GUOwei on 2018/5/16.
 */
public interface ShoppingCartDao {

    /**
     * 加入购物车
     * @param shopping_cart
     */
    public void shoppingCartInsert(Shopping_cart shopping_cart);

    /**
     * 查询该用户购物车
     * @param user_id
     * @return
     */
    public List<Shopping_cart> getShoppingCart(String user_id);

    /**
     * 通过product_id删除购物车记录
     * @param product_id
     */
    public void delShoppingCartByProId(String product_id);
}
