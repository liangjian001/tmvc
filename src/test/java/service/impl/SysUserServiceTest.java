package service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.entities.share.ResultInfo;
import com.entities.user.SysUser;
import com.entities.user.SysUserExample;
import com.service.user.SysUserService;

import base.BaseTest;

public class SysUserServiceTest extends BaseTest {
	@Autowired
	private SysUserService sysUserService;
	
	@SuppressWarnings("unchecked")
	@Test
	public void getUserListDateTest(){
		SysUserExample example = new SysUserExample();
		ResultInfo resultInfo = sysUserService.getUserListData(example);
		if (resultInfo.getResultFlag()){
			List<SysUser> list = (List<SysUser>) resultInfo.getResultObject();
			System.out.println("查询到的数据条数："+list.size());
		} else {
			System.out.println("查询用户数据失败!");
		}
	}
}
