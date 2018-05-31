package com.my.service.serviceimpl;

import com.my.dao.userDao;
import com.my.pojo.User;
import com.my.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GUOwei on 2018/4/11.
 */
@Service("userService")
public class userServiceImpl implements userService {

    @Autowired
    private userDao userDao;
    @Override
    public User selectUser(String tel) {

        return userDao.selectUserByTel(tel);
    }
    @Override
    public void insert(User user){

        userDao.insert(user);
    }
    @Override
    public List<User> getUserRecord(String tel){

        return userDao.getUserRecord(tel);
    }

    /**
     * 调用dao跟新用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }


}
