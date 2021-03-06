package com.ylp.financesys.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.ylp.financesys.dao.IBaseDao;

@Repository
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements IBaseDao<T>{
	private final String mapperLocation="com.ylp.financesys.mapper.";
	
	@Resource(name="sqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public String getMapperId(Class<?> c,String sqlId) {
		return mapperLocation+c.getSimpleName()+"Mapper."+sqlId;
	}

	@Override
	public List<T> findAll(Class<?> c, String sqlId) {
		return super.getSqlSession().selectList(getMapperId(c, sqlId));
	}

	@Override
	public List<T> findAll(Class<?> c, String sqlId, Map<String, Object> map) {
		return super.getSqlSession().selectList(getMapperId(c, sqlId),map);
	}

	@Override
	public List<T> findAll(Class<?> c, String sqlId, Object obj) {
		return super.getSqlSession().selectList(getMapperId(c, sqlId),obj);
	}

	@Override
	public T find(Class<?> c, String sqlId) {
		return super.getSqlSession().selectOne(getMapperId(c, sqlId));
	}

	@Override
	public T find(Class<?> c, String sqlId, Map<String, Object> map) {
		return super.getSqlSession().selectOne(getMapperId(c, sqlId),map);
	}

	@Override
	public T find(Class<?> c, String sqlId, Object obj) {
		return super.getSqlSession().selectOne(getMapperId(c, sqlId),obj);
	}

	@Override
	public Integer add(Class<?> c, String sqlId, Map<String, Object> map) {
		return super.getSqlSession().update(getMapperId(c, sqlId),map);
	}

	@Override
	public Integer add(Class<?> c, String sqlId, Object obj) {
		return super.getSqlSession().update(getMapperId(c, sqlId),obj);
	}

	@Override
	public Integer delete(Class<?> c, String sqlId, Map<String, Object> map) {
		return super.getSqlSession().delete(getMapperId(c, sqlId),map);
	}

	@Override
	public Integer delete(Class<?> c, String sqlId, Object obj) {
		return super.getSqlSession().delete(getMapperId(c, sqlId),obj);
	}

	@Override
	public Integer update(Class<?> c, String sqlId, Map<String, Object> map) {
		return super.getSqlSession().update(getMapperId(c, sqlId),map);

	}

	@Override
	public Integer update(Class<?> c, String sqlId, Object obj) {
		return super.getSqlSession().update(getMapperId(c, sqlId),obj);
	}

	@Override
	public Integer findFunc(Class<?> c, String sqlId) {
		return super.getSqlSession().selectOne(getMapperId(c, sqlId));
	}

	@Override
	public Integer findFunc(Class<?> c, String sqlId, Map<String, Object> map) {
		return super.getSqlSession().selectOne(getMapperId(c, sqlId),map);
	}

	@Override
	public Integer findFunc(Class<?> c, String sqlId, Object obj) {
		return super.getSqlSession().selectOne(getMapperId(c, sqlId),obj);
	}
	
}
