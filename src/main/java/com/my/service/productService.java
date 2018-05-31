package com.my.service;

import com.my.pojo.Buy;
import com.my.pojo.Evaluate;
import com.my.pojo.Pro_img;
import com.my.pojo.Product;

import java.util.List;

/**
 * Created by GUOwei on 2018/4/17.
 */
public interface productService {
    /**
     * 返回所有产品接口
     * @return
     */
    public List<Product> getAllProduct(int currPage);

    /**
     * 更新产品接口
     * @param product
     */
    public void updateProduct(Product product);

    /**
     * 获取产品数量
     * @return count数量
     */
    public String countToID();

    /**
     * 插入管理员新增的产品
     * @param product
     */
    public void insertProduct(Product product,String productClass);

    /**
     * 通过name找到产品
     * @param product_name
     * @return
     */
    public Product getProductByName(String product_name);

    /**
     * 插入产品对应的图片
     * @param pro_img
     */
    public void InsertPro_Img(Pro_img pro_img);

    /**
     * 插入用户评论数据
     * @param evaluate
     */
    public void insertEval(Evaluate evaluate);

    /**
     * 查询当前产品的所以评论
     * @param product_id
     * @return
     */
    public List<Evaluate> getEvalByProId(String product_id);

    /**
     * 获取status=3的产品，用于页面展示
     * @return List<Product>
     */
    public List<Product> getNewProduct();

    /**
     * 获取热销产品
     * @return List<Product>
     */
    public List<Product> getHotProduct();

    /**
     * 通过产品编号查询产品
     * @param product_id
     * @return Product
     */
    public Product getProductById(String product_id);

    /**
     * 插入购买数据
     * @param buy
     */
    public void insertBuy(Buy buy);

    /**
     * 通过产品类型查询不同产品
     * @param class_name
     * @return List<Product>
     */
    public List<Product> getProductByClass(String class_name);

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage();
}
