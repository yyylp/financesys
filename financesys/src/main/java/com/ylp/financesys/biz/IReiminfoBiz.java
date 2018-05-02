package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Reiminfo;

public interface IReiminfoBiz {
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);
	/**
	 * 根据员工分页查询
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> findByEmp(Integer pageNo,Integer pageSize,String eid);
	
	/**
	 * 添加报销信息
	 * @param reiminfo
	 * @return
	 */
	public int addReiminfo(Reiminfo reiminfo);
	
	/**
	 * 批量删除
	 * @param rids
	 * @return
	 */
	public int deleteReiminfo(List<String> rids);
	
	/**
	 * 更新操作
	 * @param reiminfo
	 * @return
	 */
	public int updateReiminfo(Reiminfo reiminfo);
}
