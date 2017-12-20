package com.yimai.service;

import java.util.List;

import com.yimai.entity.Tenant;
import com.yimai.entity.TenantWithBLOBs;

public interface ITenantService {

	public List<Tenant> getAll();
	
	public TenantWithBLOBs getById(Integer id);

	public boolean saveOne(Tenant itemType);
	
}
