package com.my.controller;

import com.my.pojo.User;
import com.my.service.userService;
import com.my.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by GUOwei on 2018/4/11.
 */
@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    /**
     * 用于用户登录
     * @param request
     * @return user
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(HttpServletRequest request) throws Exception{

        String telphone = request.getParameter("telphone");
        String password = request.getParameter("password");
        User user = userService.selectUser(telphone);
        if((user != null) && (password.equals(user.getUser_password()))){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            return user;
        }
        return null;
    }

    /**
     * 用于用户注册
     * @param request
     * @return User
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public User register(HttpServletRequest request) throws Exception{
        String telphone = request.getParameter("telphone");
        String password = request.getParameter("password");
        String name = request.getParameter("username");
        User user = new User();
        user.setUser_telphone(telphone);
        user.setUser_name(name);
        user.setUser_password(password);
        String user_id = IDUtils.createID();
        user.setUser_id(user_id);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        userService.insert(user);
        return user;
    }

    /**
     * 用于判断用户登录情况
     * @param request
     * @return User
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getUserSession")
    public User getUserSession(HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        return user;
    }

    /**
     * 用户查看自己的购买情况
     * @param request
     * @return List<User>
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/getUserRecord")
    public List<User> getUserRecord(HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        return userService.getUserRecord(user.getUser_telphone());
    }

    /**
     * 获取前台用户更改的信息然后更新
     * @param request
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public void updateUser(HttpServletRequest request)throws Exception{
        String telphone = request.getParameter("tel");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        User user = new User();
        user.setUser_telphone(telphone);
        user.setUser_name(name);
        user.setUser_password(password);
        HttpSession session = request.getSession();
        User userOld = (User)session.getAttribute("user");
        user.setUser_id(userOld.getUser_id());
        System.out.println("==========>>"+telphone+name+password+user.getUser_id());
        userService.updateUser(user);
    }

}
