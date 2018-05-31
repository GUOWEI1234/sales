package com.my.controller;

import com.my.pojo.Buy;
import com.my.pojo.User;
import com.my.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/8.
 */
@Controller
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private productService productService;

    /**
     * 插入购买数据
     * @param buy
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/insertBuy")
    public void insertBuy(Buy buy,HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        buy.setUser_id(user.getUser_id());
        productService.insertBuy(buy);
    }
}
