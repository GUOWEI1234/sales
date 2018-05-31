package com.my.service;

import com.my.pojo.User;

import java.util.List;

/**
 * 调用dao层接口
 * Created by GUOwei on 2018/4/11.
 */
public interface userService {
    /**
     * 通过tel查询用户
     * @param tel
     * @return User
     */
    public User selectUser(String tel);

    /**
     * 用于用户注册使用
     * @param user
     */
    public void insert(User user);

    /**
     * 调用dao获取user购物情况
     * @param tel
     * @return List<User>
     */
    public List<User> getUserRecord(String tel);

    /**
     * 调用dao跟新用户信息
     * @param user
     */
    public void updateUser(User user);
}
