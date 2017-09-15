package com.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.MybatisSqlSessionFactory;
import com.dao.user.SysUserDao;
import com.entities.share.ResultInfo;
import com.entities.user.SysUser;
import com.entities.user.SysUserExample;
import com.service.user.SysUserService;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public ResultInfo getUserListData(SysUserExample example) {
		ResultInfo resultInfo = new ResultInfo();
		SqlSession sqlSession  = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
		try {
			List<SysUser> listData = new ArrayList<SysUser>();
			listData = sysUserDao.getUserListData(sqlSession, example);
			if (null != listData && 0 < listData.size()){
				resultInfo.setResultFlag(true);
				resultInfo.setResultObject(listData);
			} else {
				resultInfo.setResultFlag(false);
				resultInfo.setResultText("没有查询到符合条件的数据!");
			}
		} catch (Exception ex){
			ex.printStackTrace();
			resultInfo.setResultFlag(false);
			resultInfo.setResultText("查询数据异常!");
		} finally {
			sqlSession.close();
		}
		return resultInfo;
	}

}
