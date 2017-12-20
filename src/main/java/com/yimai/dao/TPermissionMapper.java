package com.yimai.dao;

import java.util.List;
import java.util.Map;

import com.yimai.entity.TPermission;

public interface TPermissionMapper {
	/**
	 *
	 * @mbggenerated 2017-10-25
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 *
	 * @mbggenerated 2017-10-25
	 */
	int insert(TPermission record);

	/**
	 *
	 * @mbggenerated 2017-10-25
	 */
	int insertSelective(TPermission record);

	/**
	 *
	 * @mbggenerated 2017-10-25
	 */
	TPermission selectByPrimaryKey(Long id);

	List<String> findUserPermissions(String userName);
	
	List<TPermission> getAll();
	
	public List<Map<Object, Object>> findPermissionRole();

	/**
	 *
	 * @mbggenerated 2017-10-25
	 */
	int updateByPrimaryKeySelective(TPermission record);

	/**
	 *
	 * @mbggenerated 2017-10-25
	 */
	int updateByPrimaryKey(TPermission record);
}