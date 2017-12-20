package com.yimai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.ActiontypeMapper;
import com.yimai.entity.Actiontype;
import com.yimai.service.IActionTypeService;

@Service("actionTypeServiceImpl")
public class IActionTypeServiceImpl implements IActionTypeService {

	@Autowired
	public ActiontypeMapper actiontypeMapper;

	@Override
	public List<Actiontype> getAll() {
		return actiontypeMapper.getAll();
	}

	@Override
	public boolean saveOne(Actiontype actiontype) {
		int count = actiontypeMapper.insertSelective(actiontype);
		return count > 0 ? true : false;
	}

	@Override
	public List<Actiontype> queryByTenantid(Integer tenantid) {
		return actiontypeMapper.queryByTenantid(tenantid);
	}

	@Override
	public Actiontype getById(Integer id) {
		return actiontypeMapper.getById(id);
	}

}
