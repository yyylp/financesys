package com.ylp.financesys.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ylp.financesys.bean.Position;
import com.ylp.financesys.biz.IPositionBiz;
import com.ylp.financesys.dao.IBaseDao;
@Service
public class PositionBizImpl implements IPositionBiz{
	@Autowired
	IBaseDao baseDao;
	
	@Override
	public List<Position> findAll() {
		return baseDao.findAll(Position.class, "findAll");
	}
	
}
