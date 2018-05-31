package com.my.service.serviceimpl;

import com.my.dao.ShoppingCartDao;
import com.my.pojo.Shopping_cart;
import com.my.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/16.
 */
@Service("ShoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    /**
     * 插入购物车数据
     *
     * @param shopping_cart
     */
    @Override
    public void shoppingCartInsert(Shopping_cart shopping_cart) {
        shoppingCartDao.shoppingCartInsert(shopping_cart);
    }

    /**
     * 返回用户购物车情况
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Shopping_cart> getShoppingCart(String user_id) {
        return shoppingCartDao.getShoppingCart(user_id);
    }

    /**
     * 通过product_id删除购物车记录
     *
     * @param product_id
     */
    @Override
    public void delShoppingCartByProId(String product_id) {
        shoppingCartDao.delShoppingCartByProId(product_id);
    }
}
