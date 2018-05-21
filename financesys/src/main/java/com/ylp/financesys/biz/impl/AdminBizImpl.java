package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Admin;
import com.ylp.financesys.biz.IAdminBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class AdminBizImpl implements IAdminBiz{
	@Autowired
	IBaseDao baseDao;
	@Override
	public Admin login(String name,String pwd) {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("account", name);
		map.put("pwd", pwd);
		return (Admin) baseDao.find(Admin.class, "login", map);
	}
	
}
