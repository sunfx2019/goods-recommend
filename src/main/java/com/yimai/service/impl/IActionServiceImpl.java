package com.yimai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.ActionMapper;
import com.yimai.entity.Action;
import com.yimai.service.IActionService;

@Service("actionServiceImpl")
public class IActionServiceImpl implements IActionService {

	@Autowired
	public ActionMapper actionMapper;

	@Override
	public boolean saveOne(Action action) {
		int count = actionMapper.insertSelective(action);
		return count > 0 ? true : false;
	}

	@Override
	public List<Action> queryForActionType(Integer actionTypeId) {
		return actionMapper.queryByActionType(actionTypeId);
	}

	@Override
	public List<Action> queryActionMahoutDataForActionType(Integer actionTypeId) {
		return actionMapper.queryActionMahoutDataForActionType(actionTypeId);
	}

	@Override
	public void updateUseState(List<Long> ids) {
		actionMapper.updateUseState(ids);
	}

}
