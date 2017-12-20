package com.yimai.dao;

import java.util.List;

import com.yimai.entity.ItemType;

public interface ItemTypeMapper {
	
	ItemType getById(Integer id);
	
    int insert(ItemType record);

    int insertSelective(ItemType record);

	List<ItemType> getAll();
}