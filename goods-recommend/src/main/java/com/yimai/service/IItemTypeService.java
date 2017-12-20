package com.yimai.service;

import java.util.List;

import com.yimai.entity.ItemType;

public interface IItemTypeService {
	
	public ItemType getById(Integer id);

	public List<ItemType> getAll();

	public boolean saveOne(ItemType itemType);
	
}
