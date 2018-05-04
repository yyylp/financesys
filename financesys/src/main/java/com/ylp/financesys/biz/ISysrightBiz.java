package com.ylp.financesys.biz;

import java.util.List;
import java.util.Map;

import com.ylp.financesys.bean.Sysright;

public interface ISysrightBiz {
	/**
	 * 授权操作
	 * @param roles
	 * @param menus
	 * @return
	 */
	public int addRight(Map<String, Object> params);
	
	/**
	 * 根据角色查看权限
	 * @param map
	 * @return
	 */
	public List<String> findBySid(String sid);
	/**
	 * 根据角色查看权限是否存在
	 * @param map
	 * @return
	 */
	public Sysright findBySidMid(Sysright sysright);	
	/**
	 * 删除此次未选中的权限
	 * @param sysright
	 * @return
	 */
	public int deleteBySid(Map<String, Object> map);
}
