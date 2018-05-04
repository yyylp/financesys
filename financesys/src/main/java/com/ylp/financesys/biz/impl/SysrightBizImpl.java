package com.ylp.financesys.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Sysright;
import com.ylp.financesys.biz.ISysrightBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class SysrightBizImpl implements ISysrightBiz {
	@Autowired
	private IBaseDao baseDao;
	@Override
	public int addRight(Map<String, Object> params) {
		
		return baseDao.add(Sysright.class, "addRight", params);
	}
	@Override
	public Sysright findBySidMid(Sysright sysright) {
		return  (Sysright) baseDao.find(Sysright.class, "findBySidMid", sysright);
	}
	
	@Override
	public List<String> findBySid(String sid) {
		return  baseDao.findAll(Sysright.class, "findBySid", sid);
	}
	
	@Override
	public int deleteBySid(Map<String, Object> map) {
		return baseDao.delete(Sysright.class,"deleteBySid" , map);
	}
}
