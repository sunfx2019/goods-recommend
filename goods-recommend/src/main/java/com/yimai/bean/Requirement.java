package com.yimai.bean;

public class Requirement {
	private String customerId;//承租人id

	private String customerName;//客户名称
	
	private Integer contactorId; //联系人Id
	
	private  String contactName;//联系人名称

	private String contactPhone;//联系人电话
	
	private String sort;//需求分类
	
	private String msgSource;//信息来源
	
	private Integer ownerId;//跟进人id,token拥有者
	
	private String ownerName;//更进入姓名
	
	private String status;//状态
	
	private Integer objectId;//需求的业务Id

	
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getContactorId() {
		return contactorId;
	}

	public void setContactorId(Integer contactorId) {
		this.contactorId = contactorId;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getMsgSource() {
		return msgSource;
	}

	public void setMsgSource(String msgSource) {
		this.msgSource = msgSource;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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
	
	
	@Override
	public String toString() {
		return "Requirement [customerName=" + customerName + ", contactName=" + contactName + ", contactPhone="
				+ contactPhone + ", sort=" + sort + ", msgSource=" + msgSource + ", ownerId=" + ownerId + ", ownerName="
				+ ownerName + ", status=" + status + ", objectId=" + objectId + "]";
	}
	
	
}
