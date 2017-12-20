package com.yimai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.TenantMapper;
import com.yimai.entity.Tenant;
import com.yimai.entity.TenantWithBLOBs;
import com.yimai.service.ITenantService;

@Service("tenantServiceImpl")
public class ITenantServiceImpl implements ITenantService {

	@Autowired
	public TenantMapper tenantMapper;

	@Override
	public List<Tenant> getAll() {
		return tenantMapper.getAll();
	}

	@Override
	public boolean saveOne(Tenant tenant) {
		int count = tenantMapper.insertAsTenant(tenant);
		return count > 0 ? true : false;
	}

	@Override
	public TenantWithBLOBs getById(Integer id) {
		return tenantMapper.selectByPrimaryKey(id);
	}

}
