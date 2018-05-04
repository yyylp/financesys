package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Employer;

public interface IEmployerBiz {
	/**
	 * 分页查询所有
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);
	
	/**
	 * 添加员工
	 * @param employer
	 * @return
	 */
	public int addEmp(Employer employer);
	
	/**
	 * 批量删除
	 * @param eids
	 * @return
	 */
	public int deleteEmp(List<String> eids);
	
	/**
	 * 更新操作
	 * @param employer
	 * @return
	 */
	public int updateEmp(Employer employer);
	
	/**
	 * 登录
	 * @param map
	 * @return
	 */
	public Employer login(String name,String pwd);
	/**
	 * 通过角色查找员工
	 * @param map
	 * @return
	 */
	public List<String> findByRole(String role);
	/**
	 * 查找员工的部门经理
	 * @param map
	 * @return
	 */
	public List<String> findDeptManager(String did);
	
	public Map<String, Object> findByConditon(Map<String, Object> map,Integer pageNo, Integer pageSize);
}
