package com.inxtes.remotemessagerelay;

public class MessagePool {
    static Message message = null;
    public static void setMessage(Message message){
        MessagePool.message = message;
    }

    public static Message getMessage(){
        if (message==null){
            return null;
        }else {
            Message tmp = message;
            message = null;
            return tmp;
        }
    }
}
