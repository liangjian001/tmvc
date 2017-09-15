package com.rabbitmq;  
  
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;  
  
/**
 * 消息处理类
 * @author Administrator
 */
public class MessageHandler{  
  
    private Log log = LogFactory.getLog(MessageHandler.class);  
      
    public void handleMessage(CommonMessage message) {  
        try{  
            System.out.println("消费者tmvc收到消息...." + message);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
      
}