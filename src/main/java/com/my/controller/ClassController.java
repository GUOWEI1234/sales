package com.my.controller;

import com.my.pojo.Product;
import com.my.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/8.
 */
@Controller
@RequestMapping("/classController")
public class ClassController {

    @Autowired
    private productService productService;

    /**
     * 前台产品分类查询返回前台产品list
     * @param request
     * @return List<Product>
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getProductByClass")
    public List<Product> getProductByClass(HttpServletRequest request)throws Exception{
        String class_name = request.getParameter("class_name");
        return productService.getProductByClass(class_name);
    }
}
