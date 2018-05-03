package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Sysrole;
import com.ylp.financesys.biz.ISysroleBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class SysroleBizImpl implements ISysroleBiz{
	@Autowired
	private IBaseDao<Sysrole> baseDao;
	
	@Override
	public int addRole(Sysrole sysrole) {
		return baseDao.add(Sysrole.class, "addRole", sysrole);
	}

	@Override
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> map=new HashMap<String, Object>();
		params.put("pageNo", pageNo);
		params.put("pageSize", pageSize);
		map.put("rows", baseDao.findAll(Sysrole.class, "findByPage", params));
		map.put("total", baseDao.findAll(Sysrole.class, "getTotal"));
		return map;
	}

	@Override
	public int deleteRole(List<String> sids) {
		return baseDao.delete(Sysrole.class, "delete", sids);
	}

	@Override
	public int updateRole(Sysrole sysrole) {
		return baseDao.update(Sysrole.class, "update", sysrole);
	}

	@Override
	public List<Sysrole> findAll() {
		return baseDao.findAll(Sysrole.class, "findAll");
	}
	
}
