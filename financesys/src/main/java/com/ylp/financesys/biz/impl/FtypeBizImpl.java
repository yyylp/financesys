package com.ylp.financesys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Fitems;
import com.ylp.financesys.bean.Ftype;
import com.ylp.financesys.biz.IFtypeBiz;
import com.ylp.financesys.dao.IBaseDao;

@Service
public class FtypeBizImpl implements IFtypeBiz{
	@Autowired
	IBaseDao baseDao;
	@Override
	public Map<String, Object> findByPage(Integer pageNo, Integer pageSize) {
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Object> results=new HashMap<String, Object>();
		params.put("pageNo",pageNo );
		params.put("pageSize", pageSize);
		results.put("rows", baseDao.findAll(Ftype.class, "findByPage", params));
		results.put("total", baseDao.find(Ftype.class, "getTotal"));
		return results;
	}

	@Override
	public int addFtype(Ftype ftype) {
		if (ftype.getFname()!=null&&!"".equals(ftype.getFname())) {
			return baseDao.add(Ftype.class, "addFtype", ftype);
		}
		return 0;
	}

	@Override
	public int deleteFtype(List<String> fids) {
		return baseDao.delete(Ftype.class, "delete", fids);
	}

	@Override
	public int updateFtype(Ftype ftype) {
		return baseDao.update(Ftype.class, "update", ftype);
	}

	@Override
	public List<Ftype> findAll() {
		return baseDao.findAll(Ftype.class, "findAll");
	}

}
