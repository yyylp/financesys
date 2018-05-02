package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Employer;
import com.ylp.financesys.bean.Fitems;
import com.ylp.financesys.biz.IFitemsBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class FitemsBizImpl implements IFitemsBiz{
	@Autowired
	IBaseDao baseDao;
	
	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		results.put("rows", baseDao.findAll(Fitems.class, "findByPage", params));
		results.put("total", baseDao.find(Fitems.class, "getTotal"));
		return results;
	}

	@Override
	public int addFitems(Fitems fitems) {
		if (fitems.getIname()!=null&&!"".equals(fitems.getIname())) {			
			return baseDao.add(Fitems.class, "addFitems", fitems);
		}
		return 0;
	}

	@Override
	public int deleteFitems(List<String> imids) {
		return baseDao.delete(Fitems.class, "delete", imids);
	}

	@Override
	public int updateFitems(Fitems fitems) {
		return baseDao.update(Fitems.class, "update", fitems);
	}

	@Override
	public List<Fitems> findAll() {
		return baseDao.findAll(Fitems.class, "findAll");
	}

}
