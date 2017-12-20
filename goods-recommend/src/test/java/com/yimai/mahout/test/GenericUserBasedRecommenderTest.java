package com.yimai.mahout.test;

import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class GenericUserBasedRecommenderTest {
	
	/**
	 * <p>
	 * 		GenericUserBasedRecommender是基于用户的简单推荐器实现类，推荐主要参照传入的DataModel和UserNeighborhood，总体是三个步骤：
			(1) 从UserNeighborhood获取当前用户Ui最相似的K个用户集合{U1, U2, …Uk}；
			(2) 从这K个用户集合排除Ui的偏好商品，剩下的Item集合为{Item0, Item1, …Itemm}；
			(3) 对Item集合里每个Itemj计算Ui可能偏好程度值pref(Ui, Itemj)，并把Item按此数值从高到低排序，前N个item推荐给用户Ui。
	 * </p>
	 */
	public void userSimilarity(){
		try {

			File modelFile = new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt");
			
			DataModel model = new FileDataModel(modelFile);
			
			System.out.println("totalUserNum:" + model.getNumUsers());
			System.out.println("totalItemNum:" + model.getNumItems());

			//用户相似度，使用基于皮尔逊相关系数计算相似度
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

			//选择邻居用户，使用NearestNUserNeighborhood实现UserNeighborhood接口，选择邻近的4个用户
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(4, similarity, model);

			Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			
//			//给用户1推荐4个物品
//			List<RecommendedItem> recommendations = recommender.recommend(1, 4);
//
//			for (RecommendedItem recommendation : recommendations) {
//			    System.out.println(recommendation);
//			}
//			
//			//对相同用户重复获得推荐结果，我们可以改用CachingRecommender来包装GenericUserBasedRecommender对象，将推荐结果缓存起来：
//			Recommender cachingRecommender = new CachingRecommender(recommender);
			
			//获得所有的用户ID
	        LongPrimitiveIterator iter = model.getUserIDs();
	        while (iter.hasNext()) {
	            long uid = iter.nextLong();
	            //给用户推荐4个物品
				List<RecommendedItem> recommendations = recommender.recommend(uid, 4);
				System.out.println(uid + "/" + recommendations);
				
	        }
	        
	        
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户推荐
	 */
	public void userSimilarity2(){
		try {
			
			int NEIGHBORHOOD_NUM = 2;
		    int RECOMMENDER_NUM = 3;
			
		 	//String file = "datafile/item.csv";
			File file = new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt");
	        DataModel model = new FileDataModel(file);
	        //欧式距离相似度 算法
	        UserSimilarity user = new EuclideanDistanceSimilarity(model);
	        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
	        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);
	        //获得所有的用户ID
	        LongPrimitiveIterator iter = model.getUserIDs();

	        while (iter.hasNext()) {
	            long uid = iter.nextLong();
	            List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
	            System.out.printf("uid:%s", uid);
	            for (RecommendedItem ritem : list) {
	                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
	            }
	            System.out.println();
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用平均绝对差值获得评分
	 */
	public void recommenderEvaluator(){
		try {
			
			File modelFile = new File("D:\\workspace\\neon\\goods-recommend\\doc\\data\\intro.txt");
			
			DataModel model = new FileDataModel(modelFile);
			
			//使用平均绝对差值获得评分
			RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
			// 用RecommenderBuilder构建推荐引擎
			RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
			    @Override
			    public Recommender buildRecommender(DataModel model) throws TasteException {
			        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			        UserNeighborhood neighborhood = new NearestNUserNeighborhood(4, similarity, model);
			        return new GenericUserBasedRecommender(model, neighborhood, similarity);
			    }
			};
			// Use 70% of the data to train; test using the other 30%.
			double score = evaluator.evaluate(recommenderBuilder, null, model, 0.7, 1.0);
			System.out.println(score);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new GenericUserBasedRecommenderTest().userSimilarity();
		new GenericUserBasedRecommenderTest().userSimilarity2();
		//new GenericUserBasedRecommenderTest().recommenderEvaluator();
		
	}

}
