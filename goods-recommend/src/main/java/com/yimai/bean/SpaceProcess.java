package com.yimai.bean;

import java.util.Date;

public class SpaceProcess {


	private Integer objectId;//空间业务id
	
	private String objectType;//空间业务类型
	
	private String roomNum;//房间号
	
	private String applicant;//申请人
	
	private Date createTime;//申请的创建时间
	
	private String operator;//当前操作人
	
	private String operatorName;//当前操作人姓名
	
	private String status;//当前状态
	
	
	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}


	
	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getObjectId() {
		return objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	
	public String getRoomNum() {
		return roomNum;
	}
	
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	
	@Override
	public String toString() {
		return "SpaceProcess [objectId=" + objectId + ", objectType=" + objectType + ", roomAbsName=" + roomNum
				+ ", applicant=" + applicant + ", createTime=" + createTime + ", operator=" + operator + ", status="
				+ status + "]";
	}

	
}
