package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Menuitem;
import com.ylp.financesys.bean.Reiminfo;
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
	public List<Menuitem> findBySid(String sid) {
		return baseDao.findAll(Menuitem.class, "findBySid", sid);
	}

	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		results.put("rows", baseDao.findAll(Menuitem.class, "findByPage", params));
		results.put("total", baseDao.find(Menuitem.class, "getTotal"));
		System.out.println(params);
		System.out.println(results);
		return results;
	}

}
