package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Department;

public interface IDepartmentBiz {
	/**
	 * 添加部门信息
	 * @param department
	 * @return
	 */
	public int addDept(Department department);

	/**
	 * 分页查询所有部门信息
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 批量删除
	 * @param dids
	 * @return
	 */
	public int deleteDept(List<String> dids);
	
	/**
	 * 更新部门信息
	 * @param department
	 * @return
	 */
	public int updateDept(Department department);
	
	/**
	 * 查询所有部门
	 * @return
	 */
	public List<Department> findAll();
}
