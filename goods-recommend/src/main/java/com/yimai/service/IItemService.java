package com.yimai.service;

import java.util.List;

import com.yimai.entity.Item;

public interface IItemService {

	public Item getById(Integer id);
	
	@SuppressWarnings("rawtypes")
	public List<Item> getByIds(List ids);

	public List<Item> getAll();

	public boolean saveOne(Item item);

}
