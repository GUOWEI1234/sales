package com.my.dao;

import com.my.pojo.Product;

import java.util.List;

/**
 *
 * Created by GUOwei on 2018/4/16.
 */
public interface productDao {

    /**
     * 返回所以产品信息
     * @return List<Product>
     */
    public List<Product> getAllProduct(int currPage);

    /**
     * 管理员更新产品信息
     * @param product
     */
    public void update(Product product);

    /**
     * 获取产品数量，count+1用于新插入产品的ID；
     * @return 数据库产品数量
     */
    public int count();

    /**
     * 插入管理员新增的产品
     * @param product
     */
    public void insertProduct(Product product);

    /**
     * 通过产品名字获取产品
     * @param product_name
     * @return Product
     */
    public Product getProductByName(String product_name);

    /**
     * 获取新产品及status等于3的显示在首页。
     * @return List<Product>
     */
    public List<Product> getNewProduct();

    /**
     * 获取热销产品
     * @return List<Product>
     */
    public List<Product> getHotProduct();

    /**
     * 通过id查询产品
     * @param product_id
     * @return Product
     */
    public Product getProductById(String product_id);

    /**
     * 通过传入产品获取产品list
     * @param class_name
     * @return List<Product>
     */
    public List<Product> getProByClass(String class_name);

    /**
     * 购买产品后跟新产品库存。
     * @param product
     */
    public void updateCount(Product product);
}
