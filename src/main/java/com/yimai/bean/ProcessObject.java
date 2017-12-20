package com.yimai.bean;

import java.util.Date;
import java.util.List;

public class ProcessObject {
	
	public Integer tokenId;//tokenID
	
	public String ownerType;//角色类型，令牌拥有者类型
	
	public String ownerId;//令牌拥有者ID
	
	public String objectType;//对象类型，业务流程类型，比如TAGL（提案管理）
	
	public Integer objectId;//对象ID，业务关联流程ID。
	
	public String status;//对象状态，也就是流程状态，比如待提交 
	
	public String isActive;//是否活动，代表着该条数据是否有效
	
	public String tokenType;//令牌类型，和令牌是否活动一起判定是否有效。主要区分是并联还是串联
	
	public Date createTime;//时间类型数据
	
	public Date startTime;//开始时间
	
	public Date endTime;//结束时间
	
	public List<String> statusList;
	
	public String remark;//备注
	
	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public List<TokenPassingIO> tokenPassingIOList;//对应的迁越表信息
	
	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}


	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<TokenPassingIO> getTokenPassingIOList() {
		return tokenPassingIOList;
	}

	public void setTokenPassingIOList(List<TokenPassingIO> tokenPassingIOList) {
		this.tokenPassingIOList = tokenPassingIOList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
