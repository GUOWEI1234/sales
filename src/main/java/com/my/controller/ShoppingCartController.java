package com.my.controller;

import com.my.pojo.Shopping_cart;
import com.my.pojo.User;
import com.my.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/16.
 */
@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 加入购物车
     * @param request
     * @param shopping_cart
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public void shoppingCartInsert(HttpServletRequest request,Shopping_cart shopping_cart)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        shopping_cart.setUser_id(user.getUser_id());
        shoppingCartService.shoppingCartInsert(shopping_cart);
    }

    /**
     * 获取购物车并显示或者用于判断是否已经加入购物车！
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getShoppingCartByUserId")
    public List<Shopping_cart> getShoppingCartByUserId(HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Shopping_cart> shoppingCartList = shoppingCartService.getShoppingCart(user.getUser_id());
        return shoppingCartList;
    }

    /**
     * 传入product_id删除对应的该条购物车记录
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/delShoppingCartByProId")
    public void delShoppingCartByProId(HttpServletRequest request)throws Exception{
        String pro_id = request.getParameter("product_id");
        shoppingCartService.delShoppingCartByProId(pro_id);
    }
}
