package com.yimai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.ItemMapper;
import com.yimai.entity.Item;
import com.yimai.service.IItemService;

@Service("itemServiceImpl")
public class IItemServiceImpl implements IItemService {

	@Autowired
	public ItemMapper itemMapper;

	@Override
	public List<Item> getAll() {
		return itemMapper.getAll();
	}

	@Override
	public boolean saveOne(Item item) {
		int count = itemMapper.insertSelective(item);
		return count > 0 ? true : false;
	}

	@Override
	public Item getById(Integer id) {
		return itemMapper.selectByPrimaryKey(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Item> getByIds(List ids) {
		return itemMapper.getByIds(ids);
	}

}
