package com.yimai.dao;

import java.util.List;

import com.yimai.entity.Actiontype;

public interface ActiontypeMapper {

	int insert(Actiontype record);

	int insertSelective(Actiontype record);

	Actiontype getById(Integer id);
	
	List<Actiontype> getAll();
	
	List<Actiontype> queryByTenantid(Integer tenantid);
}