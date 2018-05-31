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
 * Created by GUOwei on 2018/4/26.
 * @author guowei
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private productService productService;

    /**
     * 更新产品数据
     * @param product
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/UpdateProduct")
    public void UpdateProduct(Product product)throws Exception{
        productService.updateProduct(product);
    }

    /**
     * 前台自动加载ajax调用，获取product
     * @return List<Product>
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getAllProduct")
    public List<Product> getAllProduct(HttpServletRequest request)throws Exception{
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        List<Product> productList = productService.getAllProduct((currPage-1)*5);
        if(productList != null){
            return productList;
        }
        return null;
    }

    /**
     * 新增产品，更新产品—类型表
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/insertProduct")
    public Product insertProduct(HttpServletRequest request)throws Exception{

        String product_name = request.getParameter("product_name");
        String product_price = request.getParameter("product_price");
        String product_intr = request.getParameter("product_intr");
        Long product_count = Long.parseLong(request.getParameter("product_count"));
        String product_statu = request.getParameter("product_statu");
        String productClassID = request.getParameter("productClass");
        Product product = new Product();
        product.setProduct_name(product_name);
        product.setProduct_price(product_price);
        product.setProduct_intr(product_intr);
        product.setProduct_count(product_count);
        product.setProduct_statu(product_statu);
        productService.insertProduct(product,productClassID);
        return product;
    }

    /**
     * 用于返回首页新品推荐
     * @return List<Product>
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getNewProduct")
    public List<Product> getNewProduct()throws Exception{
        return productService.getNewProduct();
    }

    /**
     * 返回首页显示的热销产品
     * @return List<Product>
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getHotProduct")
    public List<Product> getHotProduct()throws  Exception{
        return productService.getHotProduct();
    }

    /**
     * 通过产品id查询产品并返回产品属性
     * @param request
     * @return Product
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getProductById")
    public Product getProductById(HttpServletRequest request)throws Exception{
        String product_id = request.getParameter("product_id");
        return productService.getProductById(product_id);
    }


}
