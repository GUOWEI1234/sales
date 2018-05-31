package com.my.dao;

import com.my.pojo.User;

import java.util.List;

/**
 * Created by GUOwei on 2018/4/11.
 */
public interface userDao {
    /**
     * 通过tel找到唯一用户
     * @param tel
     * @return
     */
    public User selectUserByTel(String tel);

    /**
     * 插入用户数据
     * @param user
     */
    public void insert(User user);

    /**
     * 通过tel查询用户购买情况
     * @param tel
     * @return List<User>
     */
    public List<User> getUserRecord(String tel);

    /**
     * 用户自己跟新自己的用户信息
     * @param user
     */
    public void update(User user );
}
