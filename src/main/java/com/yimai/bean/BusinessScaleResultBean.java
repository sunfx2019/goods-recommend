package com.yimai.bean;

/**
 * 查询结果 业务关注规模 Bean
 * 
 * @author Administrator
 *
 */
public class BusinessScaleResultBean {

	private String totalArea;// 楼宇总面积
	private String alreadyArea;// 已租面积
	private String mayArea;// 可招商面积
	private String alreadyPrice;// 在租均价
	private int chckinNumber;// 入驻企业

	private int totalBuildingCount;// 总楼宇 24栋
	private String range_result1;// （已租面积）环比增幅
	private String range_result2;// （可招商面积） 环比增幅
	private String range_result3;// （在租均价）环比增幅
	private String range_result4;// （入驻企业）环比增幅

	public String getTotalArea() {
		return totalArea;
	}

	public String getAlreadyArea() {
		return alreadyArea;
	}

	public String getMayArea() {
		return mayArea;
	}

	public String getAlreadyPrice() {
		return alreadyPrice;
	}

	public int getChckinNumber() {
		return chckinNumber;
	}

	public int getTotalBuildingCount() {
		return totalBuildingCount;
	}

	public String getRange_result1() {
		return range_result1;
	}

	public String getRange_result2() {
		return range_result2;
	}

	public String getRange_result3() {
		return range_result3;
	}

	public String getRange_result4() {
		return range_result4;
	}

	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}

	public void setAlreadyArea(String alreadyArea) {
		this.alreadyArea = alreadyArea;
	}

	public void setMayArea(String mayArea) {
		this.mayArea = mayArea;
	}

	public void setAlreadyPrice(String alreadyPrice) {
		this.alreadyPrice = alreadyPrice;
	}

	public void setChckinNumber(int chckinNumber) {
		this.chckinNumber = chckinNumber;
	}

	public void setTotalBuildingCount(int totalBuildingCount) {
		this.totalBuildingCount = totalBuildingCount;
	}

	public void setRange_result1(String range_result1) {
		this.range_result1 = range_result1;
	}

	public void setRange_result2(String range_result2) {
		this.range_result2 = range_result2;
	}

	public void setRange_result3(String range_result3) {
		this.range_result3 = range_result3;
	}

	public void setRange_result4(String range_result4) {
		this.range_result4 = range_result4;
	}

}
