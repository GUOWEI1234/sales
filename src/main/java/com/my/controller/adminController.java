package com.my.controller;

import com.my.pojo.Admin;
import com.my.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 管理员操作
 * Created by GUOwei on 2018/4/16.
 */
@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminService;

    @ResponseBody
    @RequestMapping(value = "/admin_login",method = RequestMethod.GET)
    public Admin login(HttpServletRequest request) throws Exception{

        String id = request.getParameter("admin_id");
        String password = request.getParameter("password");
        Admin admin = adminService.getAdminById(id);
        if((admin != null) && (password.equals(admin.getAdmin_password()))){
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            /*session.setAttribute("username",admin.getAdmin_name());*/
            return admin;
        }
        return null;
    }

    /**
     * 用于管理员登录情况
     * @param request
     * @return Admin
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getAdminSession")
    public Admin getUserSession(HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        return admin;
    }


}
