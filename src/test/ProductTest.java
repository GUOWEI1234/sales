import com.my.dao.BuyDao;
import com.my.dao.EvaluateDao;
import com.my.dao.productDao;
import com.my.pojo.Buy;
import com.my.pojo.Evaluate;
import com.my.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ProductTest {

    @Autowired
    private EvaluateDao evaluateDao;
    @Autowired
    private productDao productDao;
    @Autowired
    private BuyDao buyDao;

    @Test
    public void insertEval()throws Exception{

        String product_id = "1";
        String user_id = "152379849429942";
        String eval = "相当差劲，不值得推荐！！";
        Evaluate evaluate = new Evaluate();
        evaluate.setProduct_id(product_id);
        evaluate.setUser_id(user_id);
        evaluate.setEvalate(eval);
        evaluateDao.InsertEval(evaluate);
    }

    @Test
    public void getEval()throws Exception{
        String product_id = "1";
        List<Evaluate> list = evaluateDao.getEvalByProId(product_id);
        for (Evaluate e : list){
            System.out.println("=============>>"+e.getEvalate());
        }
    }

    @Test
    public void getNewProduct()throws Exception{
        List<Product> list =  productDao.getNewProduct();
        /*for (Product pro : list){
            System.out.println("==========>>"+pro.getProduct_name()+pro.getPro_img().getPro_img_url());
        }*/
        for (int i=0;i<list.size();i++){
            System.out.println("==========>>"+list.get(i).getPro_img().get(i).getPro_img_url());
        }
    }

    @Test
    public void getHotProduct()throws Exception{
        List<Product> list =  productDao.getHotProduct();
        for (int i=0;i<list.size();i++){
            System.out.println("==========>>"+list.get(i).getPro_img().get(4).getPro_img_url());
        }
    }

    @Test
    public void getProductById()throws  Exception{
        String id = "1";
        Product product = productDao.getProductById(id);
        for(int i=0;i<product.getPro_img().size();i++){
            System.out.println("=========>>"+product.getPro_img().get(i).getPro_img_url());
        }

    }

    @Test
    public void insertBuy()throws Exception{
        String id = "1";
        Double price = 1.00;
        String pro_id = "1";
        String count = "1";
        Buy buy = new Buy();
        buy.setUser_id(id);
        buy.setProduct_id(pro_id);
        buy.setBuy_price(price);
        buy.setBuy_count(count);
        buyDao.insertBuy(buy);
    }

    @Test
    public void getProductByClass() throws  Exception{
        String class_name = "助听器";
        List<Product> productList = productDao.getProByClass(class_name);
        for (Product product: productList) {
            System.out.println("====>>"+product.getaClass().getClass_name());
        }
    }
}
