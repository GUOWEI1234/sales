package com.my.controller;
import com.my.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/16.
 */
@Controller
@RequestMapping(value = "/page")
public class PageController {

    @Autowired
    private productService productService;

    /**
     * 返回总页数
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getTotalPage")
    public int getTotalPage()throws Exception{
        return productService.getTotalPage();
    }
}
