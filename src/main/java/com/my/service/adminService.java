package com.my.service;

import com.my.pojo.Admin;
import com.my.pojo.Product;

import java.util.List;

/**
 * Created by GUOwei on 2018/4/16.
 */
public interface adminService {
    /**
     * 通过id登录
     * @param id
     * @return
     */
    public Admin getAdminById(String id);


}
