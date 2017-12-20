package com.yimai.dao;

import java.util.List;

import com.yimai.entity.Tenant;
import com.yimai.entity.TenantWithBLOBs;

public interface TenantMapper {
	
	List<Tenant> getAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(TenantWithBLOBs record);

    int insertAsTenant(Tenant record);

    int insertSelective(TenantWithBLOBs record);

    TenantWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TenantWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TenantWithBLOBs record);

    int updateByPrimaryKey(Tenant record);
}