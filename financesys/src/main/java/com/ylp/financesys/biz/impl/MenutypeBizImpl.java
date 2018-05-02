package com.ylp.financesys.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Menutype;
import com.ylp.financesys.biz.IMenutypeBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class MenutypeBizImpl implements IMenutypeBiz{
	@Autowired
	private IBaseDao baseDao;
	
	@Override
	public List<Menutype> findAll() {
		return baseDao.findAll(Menutype.class, "findAll");
	}

}
