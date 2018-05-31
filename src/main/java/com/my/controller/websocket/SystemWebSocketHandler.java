package com.my.controller.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author GUOwei
 */
@Component("webSockertHandle")
public class SystemWebSocketHandler implements WebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);

    private static final ConcurrentMap<String, WebSocketSession> WebSocketSessionMap = new ConcurrentHashMap<String, WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.debug("connect to the websocket success......");
        logger.debug((String) session.getAttributes().get("username")+session.getId());
        WebSocketSessionMap.put((String) session.getAttributes().get("username"), session);
    }

    /**
     * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message.getPayloadLength() == 0){
            return;
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        logger.debug("websocket connection closed......");
        WebSocketSessionMap.remove(session.getAttributes().get("username"));
    }

    /**
     * 客服端断开移除客服端session
     *
     * @param session
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.debug("websocket connection closed......");
        WebSocketSessionMap.remove(session.getAttributes().get("username"));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message 消息
     */
    public void sendMessageToUsers(TextMessage message) {
        // TODO
    }

    /**
     * 给某个用户发送消息
     *
     * @param staffId
     *          用户的名字
     * @param message
     *          消息
     */
    public void sendMessageToUser(String staffId, TextMessage message) {
        try {
            WebSocketSession session = WebSocketSessionMap.get(staffId);
            if (session != null) {
                WebSocketSessionMap.get(staffId).sendMessage(message);
            }
        } catch (IOException e) {
            logger.error("webSocket发送失败", e);
        }
    }
}
