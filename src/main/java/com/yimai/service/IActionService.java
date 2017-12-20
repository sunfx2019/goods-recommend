package com.yimai.service;

import java.util.List;

import com.yimai.entity.Action;

public interface IActionService {

	public boolean saveOne(Action action);
	
	public void updateUseState(List<Long> ids);

	public List<Action> queryForActionType(Integer actionTypeId);
	
	public List<Action> queryActionMahoutDataForActionType(Integer actionTypeId);

}
