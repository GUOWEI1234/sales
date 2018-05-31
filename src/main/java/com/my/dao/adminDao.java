package com.my.dao;

import com.my.pojo.Admin;

/**
 * 管理员操作数据库接口
 * Created by GUOwei on 2018/4/16.
 */
public interface adminDao {

    /**
     * 管理员登录
     * @param id
     * @return
     */
    public Admin getAdminById(String id);
}
