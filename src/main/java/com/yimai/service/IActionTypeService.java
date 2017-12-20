package com.yimai.service;

import java.util.List;

import com.yimai.entity.Actiontype;

public interface IActionTypeService {

	public Actiontype getById(Integer id);

	public List<Actiontype> getAll();
	
	public List<Actiontype> queryByTenantid(Integer tenantid);
	
	public boolean saveOne(Actiontype actiontype);
	
}
