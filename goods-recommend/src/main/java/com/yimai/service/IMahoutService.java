package com.yimai.service;

import java.util.List;

public interface IMahoutService {

//	/**
//	 * 给用户推荐某个行为的商品个数
//	 * @param actionTypeName	actionType表中的 name 字段值
//	 * @param userId	用户ID
//	 * @param num 推荐的商品个数
//	 */
//	@SuppressWarnings("rawtypes")
//	public List baseUserCF(String actionTypeName, Integer userId, int num);
//
//	/**
//	 * 给用户推荐相似的商品
//	 * @param actionTypeName
//	 * @param userId
//	 * @param num
//	 */
//	@SuppressWarnings("rawtypes")
//	public List baseItemCF(String actionTypeName, Integer userId, int num);

	/**
	 * 商品推荐
	 * @param actionTypeName actiontype表中的name字段值
	 * @param userId
	 * @param num
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List goodsRecommend(String stringId, String actionTypeName, Integer userId, int num);
	
	/**
	 * 创建文件
	 * @param dataFile
	 */
	public void createDataFile(String dataFile);

	/**
	 * 写入数据到文件
	 * @param actionTypeId
	 * @param dataFile
	 */
	public void writeDataToFile(Integer actionTypeId, String dataFile);

}
