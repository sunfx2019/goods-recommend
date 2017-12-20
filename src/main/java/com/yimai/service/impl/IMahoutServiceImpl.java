package com.yimai.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yimai.entity.Action;
import com.yimai.service.IActionService;
import com.yimai.service.IMahoutService;
import com.yimai.web.listener.InitMahoutDataListener;

@Service("mahoutServiceImpl")
public class IMahoutServiceImpl implements IMahoutService {

	public Log log4j = LogFactory.getLog(getClass());

	@Autowired
	public IActionService actionServiceImpl;

	@Autowired
	public IMahoutService iMahoutService;

	@Autowired
	public InitMahoutDataListener initMahoutDataListener;

	@Override
	public void createDataFile(String dataFile) {
		try {
			File f = new File(dataFile);
			if (!f.exists()) {
				String parent = f.getParent();
				if (!new File(parent).exists())
					new File(parent).mkdirs();
				f.createNewFile();
			}
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
		}
	}

	/**
	 * 写入文件的格式为 [用户ID,商品ID,评分]
	 */
	@Override
	public void writeDataToFile(Integer actionTypeId, String dataFile) {

		int pageNo = 1;
		int pageSize = 100;
		int totalPageSize = 1;

		while (pageNo <= totalPageSize) {

			List<Long> ids = new ArrayList<Long>();
			PageHelper.startPage(pageNo, pageSize); // 分页工具
			List<Action> list = actionServiceImpl.queryActionMahoutDataForActionType(actionTypeId);
			PageInfo<Action> page = new PageInfo<Action>(list);
			log4j.info(JSONArray.toJSON(page.getList()));

			if (page.getList() != null && !page.getList().isEmpty()) {
				StringBuilder lineStr = null;
				FileWriter fw = null;
				try {
					// 如果文件存在,则追加内容;如果文件不存在，则创建文件
					createDataFile(dataFile);
					File f = new File(dataFile);
					fw = new FileWriter(f, true);
				} catch (IOException e) {
					e.printStackTrace();
				}
				PrintWriter pw = new PrintWriter(fw);
				for (Action action : page.getList()) {
					ids.add(action.getId());
					lineStr = new StringBuilder();
					lineStr.append(action.getUserid());
					lineStr.append(",");
					lineStr.append(action.getItemid());
					//lineStr.append(",");
					//lineStr.append(action.getRatingvalue() == null ? 0 : action.getRatingvalue());	//评分
					log4j.info(lineStr.toString());
					// 写入一行
					pw.println(lineStr.toString());
				}
				pw.flush();
				try {
					fw.flush();
					pw.close();
					fw.close();
				} catch (Exception e) {
					log4j.error(e.getMessage(), e);
				} finally {
					actionServiceImpl.updateUseState(ids);
				}
			}

			totalPageSize = page.getPages();
			pageNo++;

		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List goodsRecommend(String stringId, String actionTypeName, Integer userId, int num) {
		
		List<RecommendedItem> list = null;
		
		try {
			
			String directory = initMahoutDataListener.DIRECTORY;	//数据文件存放的目录
			String datafile = directory + File.separator + stringId + File.separator + actionTypeName + InitMahoutDataListener.MAHOUT_DATA_FILE_SUFFIX;
			
			if(!new File(datafile).exists()){
				log4j.info("数据文件[" + datafile + "]不存在！");
				return list;
			}
			
			 // 创建数据模型，不包含用户评分
	        DataModel dm =  new GenericBooleanPrefDataModel(GenericBooleanPrefDataModel.toDataMap(new FileDataModel( new File(datafile))));
	        // 使用曼哈顿距离计算相似度
	        UserSimilarity us =  new CityBlockSimilarity(dm);

	        //指定NearestNUserNeighborhood作为近邻算法(三个参数分别是： 邻居的个数，用户相似度，数据模型 )
	        //UserNeighborhood unb =  new NearestNUserNeighborhood(10, us, dm);
	        
	        //指定距离最近的一定百分比的用户作为邻居。(三个参数分别是： 阀值（取值范围0到1之间），用户相似度，数据模型)
	        UserNeighborhood unb = new ThresholdUserNeighborhood(0.2, us, dm); 
	        
	        // 构建不包含用户评分的UserCF推荐器
	        Recommender re =  new GenericBooleanPrefUserBasedRecommender(dm, unb, us);
	        
	        // 输出推荐结果，为1号用户推荐5个商品
	        list = re.recommend(userId, num);
	        for (RecommendedItem recommendedItem : list) {
	            log4j.info(JSONArray.toJSON(recommendedItem));
	        }
	         
		} catch (Exception e) {
			log4j.error(e.getMessage(), e);
		}
		return list;
	}
	
	

//	@SuppressWarnings("rawtypes")
//	@Override
//	public List baseUserCF(String actionTypeName, Integer userId, int num) {
//		
//		// 1,构建模型
//		DataModel dataModel;
//		
//		try {
//			dataModel = new FileDataModel(new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt"));
//			// 2,计算相似度
//			UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
//			// 3,查找k紧邻
//			UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(2, userSimilarity, dataModel);
//			// 4,构造推荐引擎
//			Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
//			
//			//dataModel.getUserIDs();	//获取全部的用户ID集合
//			//dataModel.getItemIDs();	//获取全部的物品ID集合
//			
//			//为用户i推荐两个Item
//			List<RecommendedItem> recommendations = recommender.recommend(userId, num);
//			return recommendations;
//			
//		} catch (Exception e) {
//			log4j.error(e.getMessage(), e);
//			return null;
//		}
//		
//	}
//
//	@SuppressWarnings("rawtypes")
//	@Override
//	public List baseItemCF(String actionTypeName, Integer userId, int num) {
//		
//		DataModel model;
//		
//		try {
//			
//			model = new FileDataModel(new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt"));
//			ItemSimilarity itemsimilarity = new PearsonCorrelationSimilarity(model);
//			Recommender recommender = new GenericItemBasedRecommender(model, itemsimilarity);
//			// 给用户1 推荐1件商品
//			List<RecommendedItem> recommendations = recommender.recommend(userId, num);
//			return recommendations;
//			
//		} catch (Exception e) {
//			log4j.error(e.getMessage(), e);
//			return null;
//		}
//		
//	}

}
