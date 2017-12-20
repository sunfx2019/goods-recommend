package com.yimai.bean;

/**
 * 查询结果 Area Bean
 * 
 * @author Administrator
 *
 */
public class BuildingAreaBean {

	private String buildingId; // 楼宇
	private String buildingName; // 楼宇名称
	private String totalArea;// 总面积
	private String alreadyArea;// 已租面积
	private String mayArea;// 可租面积
	private String alreadyPrice;// 在租均价
	private int chckinNumber;// 入住企业数

	public String getBuildingId() {
		return buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getTotalArea() {
		return totalArea == null ? "0" : totalArea;
	}

	public String getAlreadyArea() {
		return alreadyArea == null ? "0" : alreadyArea;
	}

	public String getMayArea() {
		return mayArea == null ? "0" : mayArea;
	}

	public String getAlreadyPrice() {
		return alreadyPrice == null ? "0" : alreadyPrice;
	}

	public int getChckinNumber() {
		return chckinNumber;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

}
