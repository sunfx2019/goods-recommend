package com.yimai.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yimai.dao.ItemTypeMapper;
import com.yimai.entity.ItemType;
import com.yimai.service.IItemTypeService;

@Service("iItemTypeServiceImpl")
public class IItemTypeServiceImpl implements IItemTypeService {

	@Autowired
	public ItemTypeMapper itemTypeMapper;

	@Override
	public List<ItemType> getAll() {
		return itemTypeMapper.getAll();
	}

	@Override
	public boolean saveOne(ItemType itemType) {
		int count = itemTypeMapper.insertSelective(itemType);
		return count > 0 ? true : false;
	}

	@Override
	public ItemType getById(Integer id) {
		return itemTypeMapper.getById(id);
	}

}
