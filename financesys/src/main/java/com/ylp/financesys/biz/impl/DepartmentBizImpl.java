package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Department;
import com.ylp.financesys.biz.IDepartmentBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class DepartmentBizImpl implements IDepartmentBiz{
	@Autowired
	IBaseDao baseDao;
	@Override
	public int addDept(Department department) {
		if (department.getDname()!=null && !department.getDname().equals("")) {			
			return baseDao.add(Department.class, "addDept", department);
		}
		return 0;
	}

	@Override
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("pageNo", pageNo);
		params.put("pageSize", pageSize);
		Map<String, Object> result=new HashMap<String, Object>();
		result.put("rows", baseDao.findAll(Department.class, "findByPage",params));
		result.put("total", baseDao.find(Department.class, "getTotal"));
		return result;
	}

	@Override
	public int deleteDept(List<String> dids) {
		return baseDao.delete(Department.class, "delete", dids);
	}

	@Override
	public int updateDept(Department department) {
		return baseDao.update(Department.class, "update", department);
	}

	@Override
	public List<Department> findAll() {
		return baseDao.findAll(Department.class, "findAll");
	}

}
