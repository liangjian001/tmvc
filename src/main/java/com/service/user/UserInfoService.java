package com.service.user;

import java.util.List;

import com.entities.user.UserInfo;

public interface UserInfoService {
	public UserInfo getUserById(int id);
	
	public List<UserInfo> getUsers(UserInfo userInfo);
	
	public int insertUser(UserInfo userInfo);

	public int deleteUserById(int id);
}
