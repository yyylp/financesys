package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Menuitem;

public interface IMenuitemBiz {
	/**
	 * 查询所有权限
	 * @return
	 */
	public List<Menuitem> findAll();
	
	/**
	 * 查询指定员工的权限
	 * @param eid
	 * @return
	 */
	public List<Menuitem> findBySid(String sid);

	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);
}
