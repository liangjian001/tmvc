package com.dao.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.entities.user.SysUser;
import com.entities.user.SysUserExample;
import com.mapper.user.SysUserMapper;

@Repository
public class SysUserDao {
	public List<SysUser> getUserListData(SqlSession sqlSession, SysUserExample example) {
		SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
		return mapper.selectByExample(example);
	}
	
}
