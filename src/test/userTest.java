import com.my.dao.adminDao;
import com.my.dao.userDao;
import com.my.pojo.Admin;
import com.my.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by GUOwei on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class userTest {

    @Autowired
    private userDao userDao;
    @Autowired
    private adminDao adminDao;

    @Test
    public void testSelectUser() throws Exception {
        String tel = "18428333316";
        User user = userDao.selectUserByTel(tel);
        System.out.println(user.getUser_name());
    }
    @Test
    public void getRecord() throws Exception{
        String tel = "18428333316";
        List<User> userList = userDao.getUserRecord(tel);
        for(int i=0;i<userList.size();i++){
            System.out.println(userList.get(i).getProduct().getProduct_name());
        }
    }

    @Test
    public void getAdmin() throws Exception{
        String id = "1";
        Admin admin = adminDao.getAdminById(id);
        System.out.println("===========>>"+admin.getAdmin_name());
    }

}
