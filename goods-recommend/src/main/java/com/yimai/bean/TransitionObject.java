package com.yimai.bean;

import java.util.Date;
import java.util.List;

public class TransitionObject {
	
	public Integer transitionId;
	
	public String beforeStatus;//转换前状态
	
	public String afterStatus;//转换后状态
	
	public Integer operatorID;//操作人ID
	
	public String exception;//转换异常原因
	
	public String transactionName;//迁越名称
	
	public String comments;//备注
	
	public Date createTime;//创建时间
	
	public List<TokenPassingIO> tokenPassingIOList;//对应的迁越表信息

	
	
	public Integer getTransitionId() {
		return transitionId;
	}

	public void setTransitionId(Integer transitionId) {
		this.transitionId = transitionId;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getBeforeStatus() {
		return beforeStatus;
	}

	public void setBeforeStatus(String beforeStatus) {
		this.beforeStatus = beforeStatus;
	}

	public String getAfterStatus() {
		return afterStatus;
	}

	public void setAfterStatus(String afterStatus) {
		this.afterStatus = afterStatus;
	}

	public Integer getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(Integer operatorID) {
		this.operatorID = operatorID;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
	
	

}
