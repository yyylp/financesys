package com.ylp.financesys.biz;

import java.util.Map;

import com.ylp.financesys.bean.Admin;

public interface IAdminBiz {
	/**
	 * 管理员登录
	 * @param map
	 * @return
	 */
	public Admin login(String name,String pwd);
}
