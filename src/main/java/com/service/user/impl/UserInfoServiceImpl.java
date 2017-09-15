package com.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entities.user.UserInfo;
import com.service.user.UserInfoService;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)//容器不为这个方法开启事务
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserInfo> getUsers(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)//如果有事务, 那么加入事务, 没有的话新建一个(默认情况下)
	public int insertUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int deleteUserById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
