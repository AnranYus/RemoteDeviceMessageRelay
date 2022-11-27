package com.inxtes.remotemessagerelay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ApiController {
    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/api/getMessage")
    @ResponseBody
    public String getMessage() {
        try {
            WebSocketServer.sendGetCommand();
        }catch (IOException e){
            LOG.error(e.getMessage());
            return "设备不在线";
        }

        Message message = null;
        while (message==null){
            try {
                Thread.sleep(500);
                message = MessagePool.getMessage();
            } catch (InterruptedException e) {
                LOG.error(e.toString());
            }
        }

        return message.toString();
    }
}
