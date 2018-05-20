package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonElement;
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
	
	/**
	 * 条件查询
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Map<String, Object> findByCondition(Integer pageNo,Integer pageSize,Map<String, Object> map);
	
	/**
	 * 根据rid查找
	 * @param rid
	 * @return
	 */
	public Reiminfo findByRid(String rid);
	/**
	 * 审核报销
	 */
	public int checkReim(Map<String, Object> map);
}
