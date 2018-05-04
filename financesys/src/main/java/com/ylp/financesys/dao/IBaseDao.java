package com.ylp.financesys.dao;

import java.util.List;
import java.util.Map;
/**
 * 数据模型层接口
 * @author Fiona
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	public List<T> findAll(Class<?> c,String sqlId);
	
	public List<T> findAll(Class<?> c,String sqlId,Map<String, Object> map);
	
	public List<T> findAll(Class<?> c,String sqlId,Object obj);
		
	public T find(Class<?> c,String sqlId);
	
	public T find(Class<?> c,String sqlId,Map<String, Object> map);
	
	public T find(Class<?> c,String sqlId,Object obj);
	
	public Integer add(Class<?> c,String sqlId,Map<String, Object> map);
	
	public Integer add(Class<?> c,String sqlId,Object object);
	
	public Integer delete(Class<?> c,String sqlId,Map<String, Object> map);
	
	public Integer delete(Class<?> c,String sqlId,Object obj);
	
	public Integer update(Class<?> c,String sqlId,Map<String, Object> map);
	
	public Integer update(Class<?> c,String sqlId,Object obj);
	
	public Integer findFunc(Class<?> c,String sqlId);
	
	public Integer findFunc(Class<?> c,String sqlId,Map<String, Object> map);
	
	public Integer findFunc(Class<?> c,String sqlId,Object obj);
	
	
}
