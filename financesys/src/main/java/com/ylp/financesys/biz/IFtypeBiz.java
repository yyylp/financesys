package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Ftype;

public interface IFtypeBiz {
	/**
	 * 分页查询所有
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String, Object> findByPage(Integer pageNo,Integer pageSize);

	/**
	 * 添加类目
	 * @param Ftype
	 * @return
	 */
	public int addFtype(Ftype ftype);

	/**
	 * 删除类目
	 * @param imids
	 * @return
	 */
	public int deleteFtype(List<String> fids);
	
	/**
	 * 更新类目
	 * @param Ftype
	 * @return
	 */
	public int updateFtype(Ftype Ftype);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Ftype> findAll();
}
