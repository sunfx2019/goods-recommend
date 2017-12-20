package com.yimai.dao;

import java.util.List;

import com.yimai.entity.Action;

public interface ActionMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Action record);

    int insertSelective(Action record);

    Action selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
    
    int updateUseState(List<Long> ids);

    List<Action> queryByActionType(Integer actionTypeId);
    
    List<Action> queryActionMahoutDataForActionType(Integer actionTypeId);
    
}