package com.yimai.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.TPermissionMapper;
import com.yimai.dao.TRoleMapper;
import com.yimai.dao.TUserMapper;
import com.yimai.entity.TUser;
import com.yimai.service.IUserService;

@Service("userServiceImpl")
public class IUserServiceImpl implements IUserService {

	@Autowired
	private TUserMapper tUserMapper;
	
	@Autowired
	private TRoleMapper tRoleMapper;
	
	@Autowired
	private TPermissionMapper tPermissionMapper;

	@Override
	public List<TUser> fiandAll() {
		return tUserMapper.fiandAll();
	}

	@Override
	public TUser findUserByUserName(String userName) {
		return tUserMapper.finByUserName(userName);
	}

	@Override
	public List<String> findUserRoles(String userName) {
		return tRoleMapper.findUserRoles(userName);
	}

	@Override
	public List<String> findUserPermissions(String userName) {
		return tPermissionMapper.findUserPermissions(userName);
	}

	public TUserMapper gettUserMapper() {
		return tUserMapper;
	}

	public void settUserMapper(TUserMapper tUserMapper) {
		this.tUserMapper = tUserMapper;
	}

}
