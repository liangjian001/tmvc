package rabbitmq;  
  
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.CommonMessage;
import com.rabbitmq.MessageSender;  
  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:spring/spring-rabbitmq.xml")
public class RabbitMQDemo {  
  
    @Resource  
    private MessageSender messageSender;  
    
    //测试消息发送
    @Test  
    public void testSendMessage(){
        CommonMessage message = new CommonMessage();
        message.setSource("tonson");
        JSONObject obj = new JSONObject();
        obj.put("test1", "test json message1");
        message.setMessage(obj);
        messageSender.setRoutingKey("message.tonson");
        messageSender.sendDataToQueue(message);
        
        JSONObject obj2 = new JSONObject();
        obj2.put("test2", "test json message2");
        message.setMessage(obj);
        messageSender.setRoutingKey("message.test");  
        messageSender.sendDataToQueue(message); 
    }
      
}