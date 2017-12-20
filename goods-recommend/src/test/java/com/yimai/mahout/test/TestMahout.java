package com.yimai.mahout.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class TestMahout {
	
	/**
	 * load DB data
	 */
	public void mahoutWithMysqlDataSource (){
		try {
			long t1=System.currentTimeMillis();
			//Class.forName("com.mysql.jdbc.Driver");
			MysqlDataSource dataSource=new MysqlDataSource(); 
	        dataSource.setServerName("localhost");  
	        dataSource.setUser("root");  
	        dataSource.setPassword("root");  
	        dataSource.setDatabaseName("goods_recommend");  
	        JDBCDataModel dataModel=new MySQLJDBCDataModel(dataSource,"action","id","itemId","ratingValue", "actionTime");  
	    //  JDBCDataModel dataModel=new MySQLJDBCDataModel(dataSource,"mytable01","uid","iid","val",null);  
	        DataModel model=dataModel;  
	        UserSimilarity similarity=new PearsonCorrelationSimilarity(model); 
	        //选择邻近的4个用户
	        UserNeighborhood neighborhood=new NearestNUserNeighborhood(2,similarity,model);  
	        Recommender recommender=new GenericUserBasedRecommender(model,neighborhood,similarity);  
	        // the Recommender.recommend() method's arguments: first one is the user id;  
	        //     the second one is the number recommended
	        //给用户1推荐2个物品
	        List<RecommendedItem> recommendations=recommender.recommend(1, 2);  
	        for(RecommendedItem recommendation:recommendations){  
	            System.out.println(recommendation);  
	        }  
	        System.out.println("done and time spend:"+(System.currentTimeMillis()-t1));  
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	// 基于用户相似度的协同过滤推荐实现
	public void baseUserCF() {
		// 1,构建模型
		DataModel dataModel;
		try {
			dataModel = new FileDataModel(new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt"));
			// 2,计算相似度
			UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(dataModel);
			// 3,查找k紧邻（三个参数分别是： 邻居的个数，用户相似度，数据模型 ）
			UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(2, userSimilarity, dataModel);
			// 4,构造推荐引擎
			Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);
			// 为用户i推荐两个Item
			for (int i = 1; i < 6; i++) {
				System.out.println("recommand  for user:" + i);
				List<RecommendedItem> recommendations = recommender.recommend(i, 2);
				for (RecommendedItem recommendation : recommendations) {
					System.out.println(recommendation);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 基于内容相似度的协同过滤推荐实现
	public void baseItemCF() {
		DataModel model;
		try {
			model = new FileDataModel(new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt"));
			ItemSimilarity itemsimilarity = new PearsonCorrelationSimilarity(model);
			Recommender recommender = new GenericItemBasedRecommender(model, itemsimilarity);
			//给用户1 推荐1件商品
			List<RecommendedItem> recommendations = recommender.recommend(1, 2);
			for (RecommendedItem recommendation : recommendations) {
				System.out.println(recommendation);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 基于SlopOne的推荐实现 SlopeOneRecommender算法 已经去除
	 */
	public void baseSlopOne() {
//		DataModel model;
//		try {
//			model = new FileDataModel(new File("d://test.txt"));
//			Recommender recommender = new SlopeOneRecommender(model);
//			List<RecommendedItem> recommendations = recommender.recommend(1, 1);
//			for (RecommendedItem recommendation : recommendations) {
//				System.out.println(recommendation);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Io Error");
//			e.printStackTrace();
//		} catch (TasteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Taste Error");
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		
		new TestMahout().baseUserCF();
		//new TestMahout().baseItemCF();
		//new TestMahout().mahoutWithMysqlDataSource();
		
	}

}
