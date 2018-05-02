package com.ylp.financesys.biz;

import java.util.List;

import com.ylp.financesys.bean.Menutype;

public interface IMenutypeBiz {
	/**
	 * 查询所有
	 * @return
	 */
	public List<Menutype> findAll();
}
