package com.yimai.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.TPermissionMapper;
import com.yimai.entity.TPermission;
import com.yimai.service.IPermissService;

@Service("permissServiceImpl")
public class IPermissServiceImpl implements IPermissService {

	@Autowired
	private TPermissionMapper tPermissionMapper;

	@Override
	public List<TPermission> findAll() {
		return tPermissionMapper.getAll();
	}

	@Override
	public List<Map<Object, Object>> findPermissionRole() {
		return tPermissionMapper.findPermissionRole();
	}

}
