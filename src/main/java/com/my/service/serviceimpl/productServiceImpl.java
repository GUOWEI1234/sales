package com.my.service.serviceimpl;

import com.my.dao.*;
import com.my.pojo.*;
import com.my.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author guowei
 * Created by GUOwei on 2018/4/17.
 */
@Service("productService")
public class productServiceImpl implements productService {

    @Autowired
    private productDao productDao;
    @Autowired
    private Pro_ClassDao pro_classDao;
    @Autowired
    private Pro_ImgDao pro_imgDao;
    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private BuyDao buyDao;

    /**
     * 插入产品对应的图片
     * @param pro_img
     */
    @Override
    public void InsertPro_Img(Pro_img pro_img) {
        pro_imgDao.insertPro_Img(pro_img);
    }

    /**
     * 插入用户评论数据
     * @param evaluate
     */
    @Override
    public void insertEval(Evaluate evaluate) {
        evaluateDao.InsertEval(evaluate);
    }

    /**
     * 查询当前产品的所以评论
     * @param product_id
     * @return List<Evaluate>
     */
    @Override
    public List<Evaluate> getEvalByProId(String product_id) {
        return evaluateDao.getEvalByProId(product_id);
    }

    /**
     * 获取status=3的产品，用于页面展示
     * @return List<Product>
     */
    @Override
    public List<Product> getNewProduct() {
        return productDao.getNewProduct();
    }

    /**
     * 获取热销产品
     * @return List<Product>
     */
    @Override
    public List<Product> getHotProduct() {
        return productDao.getHotProduct();
    }

    /**
     * 通过产品编号查询产品
     * @param product_id
     * @return Product
     */
    @Override
    public Product getProductById(String product_id) {
        return productDao.getProductById(product_id);
    }

    /**
     * 插入购买数据,并更改count
     * @param buy
     */
    @Override
    public void insertBuy(Buy buy) {
        Product product = new Product();
        product.setProduct_id(buy.getProduct_id());
        Long count = productDao.getProductById(buy.getProduct_id()).getProduct_count();
        System.out.println("========>>"+count);
        Long buyCount = Long.parseLong(buy.getBuy_count());
        product.setProduct_count(count-buyCount);
        productDao.updateCount(product);
        buyDao.insertBuy(buy);
    }

    /**
     * 通过产品类型查询不同产品
     * @param class_name
     * @return List<Product>
     */
    @Override
    public List<Product> getProductByClass(String class_name) {
        return productDao.getProByClass(class_name);
    }

    /**
     * 获取总页数
     *
     * @return
     */
    @Override
    public int getTotalPage() {
        int total = productDao.count();
        return ((total/5)+1);
    }

    /**
     * 返回所有产品
     * @return ist<Product>
     */
    @Override
    public List<Product> getAllProduct(int currPage) {
        return productDao.getAllProduct(currPage);
    }

    /**
     * 更新产品
     * @param product
     */
    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    /**
     * 获取产品数量
     * @return count数量
     */
    @Override
    public String countToID() {
        return (productDao.count()+1)+"";
    }

    /**
     * 插入管理员新增的产品
     * @param product
     */
    @Override
    public void insertProduct(Product product,String productClassID) {
        product.setProduct_id((productDao.count()+1)+"");
        productDao.insertProduct(product);
        Pro_class pro_class = new Pro_class();
        pro_class.setProduct_id(product.getProduct_id());
        pro_class.setClass_id(productClassID);
        pro_classDao.insertProClass(pro_class);
    }

    /**
     * 通过name找到产品
     * @param product_name
     * @return
     */
    @Override
    public Product getProductByName(String product_name) {
        return productDao.getProductByName(product_name);
    }
}
