package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Employer;
import com.ylp.financesys.biz.IEmployerBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class EmployerBizImpl implements IEmployerBiz{
	@Autowired
	IBaseDao baseDao;
	
	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		results.put("rows", baseDao.findAll(Employer.class, "findByPage", params));
		results.put("total", baseDao.find(Employer.class, "getTotal"));
		return results;
	}

	@Override
	public int addEmp(Employer employer) {
		if (employer.getEname()!=null &&!"".equals(employer.getEname())) {
			return baseDao.add(Employer.class, "addEmp", employer);
		}
		return 0;
	}

	@Override
	public int deleteEmp(List<String> eids) {
		return baseDao.delete(Employer.class, "delete", eids);
	}

	@Override
	public int updateEmp(Employer employer) {
		return baseDao.update(Employer.class, "update", employer);
	}

	@Override
	public Employer login(String name,String pwd) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("name",name);
		map.put("pwd", pwd);
		return (Employer) baseDao.find(Employer.class, "login", map);
	}

	@Override
	public List<String> findByRole(String role) {
		return baseDao.findAll(Employer.class, "findByRole", role);
	}

	@Override
	public List<String> findDeptManager(String did) {
		return baseDao.findAll(Employer.class, "findDeptManager", did);
	}

	@Override
	public Map<String, Object> findByConditon(Map<String, Object> map,Integer pageNo, Integer pageSize) {
		Map<String, Object> results=new HashMap<String, Object>();
		Map<String, Object> params=map;
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		
		results.put("rows",  baseDao.findAll(Employer.class, "findByCondition", params));
		results.put("total", baseDao.find(Employer.class, "getTotalByCondition", map));
		System.out.println(results);
		return results;
	}

}
