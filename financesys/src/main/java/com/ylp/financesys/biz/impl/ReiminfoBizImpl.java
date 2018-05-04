package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Reiminfo;
import com.ylp.financesys.biz.IReiminfoBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class ReiminfoBizImpl implements IReiminfoBiz{
	@Autowired
	IBaseDao<Reiminfo> baseDao;
	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		results.put("rows", baseDao.findAll(Reiminfo.class, "findByPage", params));
		results.put("total", baseDao.find(Reiminfo.class, "getTotal"));
		return results;
	}

	@Override
	public Map<String, Object> findByEmp(Integer pageNo, Integer pageSize,
			String eid) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		params.put("eid", eid);
		results.put("rows", baseDao.findAll(Reiminfo.class, "findByEmp", params));
		results.put("total", baseDao.find(Reiminfo.class, "getTotalByEmp",eid));
		return results;
	}

	@Override
	public int addReiminfo(Reiminfo reiminfo) {
		return baseDao.add(Reiminfo.class, "addReiminfo", reiminfo);
	}

	@Override
	public int deleteReiminfo(List<String> rids) {
		return baseDao.delete(Reiminfo.class, "deleteReiminfo", rids);
	}

	@Override
	public int updateReiminfo(Reiminfo reiminfo) {
		return baseDao.update(Reiminfo.class, "updateReiminfo", reiminfo);
	}

	@Override
	public Map<String, Object> findByCondition(Integer pageNo,
			Integer pageSize, Map<String, Object> map) {
		Map<String, Object> params=map;
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		results.put("rows", baseDao.findAll(Reiminfo.class, "findByCondition", params));
		results.put("total", baseDao.find(Reiminfo.class, "getTotalByCondition",map));
		System.out.println(results);
		return results;
	}

	@Override
	public Reiminfo findByRid(String rid) {
		return (Reiminfo) baseDao.find(Reiminfo.class, "findByRid", rid);
	}

}
