package com.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.entities.share.ResultInfo;
import com.entities.user.SysUser;
import com.entities.user.SysUserExample;
import com.rabbitmq.CommonMessage;
import com.rabbitmq.MessageSender;
import com.service.user.SysUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Resource  
    private MessageSender messageSender;
    @Autowired
    private SysUserService sysUserService;
    
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/index")
	public String index(){
		 //测试查询数据
		SysUserExample example = new SysUserExample();
		ResultInfo resultInfo = sysUserService.getUserListData(example);
		if (resultInfo.getResultFlag()){
			List<SysUser> list = (List<SysUser>) resultInfo.getResultObject();
			System.out.println("查询到的数据条数："+list.size());
		} else {
			System.out.println("查询用户数据失败!");
		}
		return "index";
	}
	
	@RequestMapping(value="/getUserList")
	public String getUserList(){
		 CommonMessage message = new CommonMessage();
		 message.setComments("查询一下系统目前用户数量");
		 message.setPrimaryKey("001");
	     message.setSource("1");
	     JSONObject obj = new JSONObject();  
	     obj.put("test", "test json message");  
	     obj.put("username", "user001");
	     obj.put("companyid", "10900011");
	     obj.put("operatedate", "2017-09-13");
	     message.setMessage(obj);  
	     messageSender.setRoutingKey("message.tonson");  
	     messageSender.sendDataToQueue(message);
		return "user/user";
	}
	
	@RequestMapping(value="/getUserInfo")
	public String getUserInfo(){
		 CommonMessage message = new CommonMessage();
		 message.setComments("查询一下指定用户的基本信息");
		 message.setPrimaryKey("001");
	     message.setSource("2");
	     SysUser user = new SysUser();
	     user.setUserId("admin");
	     //JSONObject obj = JSONObject.parseObject(JSONObject.toJSONString(user));
	     message.setMessage(user);  
	     messageSender.setRoutingKey("message.tonson");  
	     messageSender.sendDataToQueue(message);
		return "user/user";
	}
}
