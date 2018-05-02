package com.ylp.financesys.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Menuitem;
import com.ylp.financesys.biz.IMenuitemBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class MenuitemBizImpl implements IMenuitemBiz{
	@Autowired
	private IBaseDao baseDao;	
	@Override
	public List<Menuitem> findAll() {
		return baseDao.findAll(Menuitem.class, "findAll");
	}

	@Override
	public List<Menuitem> findByEmp(String eid) {
		return baseDao.findAll(Menuitem.class, "findByEmp", eid);
	}

}
