package com.yimai.bean;

import java.util.Date;

public class SpaceHisObj {
	private Integer id;//标识id
	
	private Integer	objId;//业务Id
	
	private String objType;//业务类型
	
	private String roomNum;//房间号
	
	private String operateName;//申请人名字
	
	private Date operateTime;//申请时间
	
	private String result;//审批结果
	
	private String comments;//审批意见
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getObjId() {
		return objId;
	}

	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}

	public String getOperateName() {
		return operateName;
	}

	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
