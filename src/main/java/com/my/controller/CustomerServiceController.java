package com.my.controller;

import com.my.controller.websocket.SystemWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GUOwei
 * Created by GUOwei on 2018/5/14.
 * 处理在线客服发送消息
 */

@Controller
@RequestMapping(value = "/webSocket")
public class CustomerServiceController {

    @Bean
    public SystemWebSocketHandler infoHandler(){
        return new SystemWebSocketHandler();
    }

    @ResponseBody
    @RequestMapping(value = "/send")
    public void sendMsg(HttpServletRequest request){
        String username = request.getParameter("username");
        String msg = request.getParameter("msg");
        infoHandler().sendMessageToUser(username, new TextMessage(msg));
    }

}
