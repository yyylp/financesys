package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Sysrole;

public interface ISysroleBiz {
	/**
	 * 添加新角色
	 * @param sysrole
	 * @return
	 */
	public int addRole(Sysrole sysrole);
	
	/**
	 * 分页查询所有
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 批量删除角色
	 * @param sids
	 * @return
	 */
	public int deleteRole(List<String> sids); 
	
	/**
	 * 更新角色
	 * @param sysrole
	 * @return
	 */
	public int updateRole(Sysrole sysrole);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Sysrole> findAll();

}
