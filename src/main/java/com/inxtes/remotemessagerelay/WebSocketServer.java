package com.inxtes.remotemessagerelay;

import com.google.gson.Gson;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;


@Component
@ServerEndpoint("/websocket")
public class WebSocketServer {
    private static final Logger LOG = LoggerFactory.getLogger(WebSocketServer.class);

    static Session session;
    @OnOpen
    public void onOpen(Session session){
        WebSocketServer.session = session;
        LOG.warn("Device connected in ");
    }

    @OnMessage
    public void onMessage(String str){

        try {
            Message message = new Gson().fromJson(str, Message.class);
            MessagePool.setMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    static public void sendGetCommand() throws IOException {
        session.getBasicRemote().sendText("get");
        LOG.warn("Send get command");
    }
}
