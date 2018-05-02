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
	
}
