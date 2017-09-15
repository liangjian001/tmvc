package com.service.user;

import com.entities.share.ResultInfo;
import com.entities.user.SysUserExample;

public interface SysUserService {
	public ResultInfo getUserListData(SysUserExample example);
}
