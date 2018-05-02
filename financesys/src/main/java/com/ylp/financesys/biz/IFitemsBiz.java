package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Fitems;

public interface IFitemsBiz {
	/**
	 * 分页查询所有
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);

	/**
	 * 添加类目
	 * @param fitems
	 * @return
	 */
	public int addFitems(Fitems fitems);

	/**
	 * 删除类目
	 * @param imids
	 * @return
	 */
	public int deleteFitems(List<String> imids);
	
	/**
	 * 更新类目
	 * @param fitems
	 * @return
	 */
	public int updateFitems(Fitems fitems);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Fitems> findAll();
}
