package com.my.controller.websocket;

import com.my.pojo.Admin;
import com.my.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * Socket建立连接（握手）和断开
 * @author GUOwei
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    private static Logger logger = LoggerFactory.getLogger(HandshakeInterceptor.class);

    /**
     * 未登录的用户建立socket连接将会失败
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session != null) {
                User user = (User)session.getAttribute("user");
                //String userName = String.valueOf(session.getAttribute("user"));
                if (null != user) {
                    System.out.println("=======>>"+user.getUser_name());
                    attributes.put("username", user.getUser_name());
                } else {
                    Admin admin = (Admin)session.getAttribute("admin");
                    if(admin != null){
                        System.out.println("=======>>"+admin.getAdmin_name());
                        attributes.put("username", admin.getAdmin_name());
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {
    }
}
