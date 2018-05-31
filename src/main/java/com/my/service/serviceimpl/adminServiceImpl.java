package com.my.service.serviceimpl;

import com.my.dao.adminDao;
import com.my.pojo.Admin;
import com.my.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GUOwei on 2018/4/16.
 */
@Service("adminService")
public class adminServiceImpl implements adminService {

    @Autowired
    private adminDao adminDao;

    @Override
    public Admin getAdminById(String id) {

        return adminDao.getAdminById(id);
    }


}
