package com.yimai.dao;

import java.util.List;

import com.yimai.entity.Item;

public interface ItemMapper {

    List<Item> getAll();

    @SuppressWarnings("rawtypes")
	List<Item> getByIds(List ids);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKeyWithBLOBs(Item record);

    int updateByPrimaryKey(Item record);
}