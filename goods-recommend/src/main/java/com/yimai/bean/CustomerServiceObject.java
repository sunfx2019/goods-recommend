package com.yimai.bean;

import java.util.Date;

public class CustomerServiceObject {
	public Integer chengzuId;//承租人ID
	public Integer contactsId;//联系人ID
	public Integer contractId;//合同ID

	public Integer rowSpan;

	public String customerName;// 客户名称

	public String contractCode;// 合同号

	public String projectName;// 项目名称

	public String roomName;// 房间号
	
	public String buildingName;//楼宇名字
	

	public String industry;// 行业

	public String customerLevel;// 客户级别

	public String contactsName;// 联系人

	public Integer rowNum;

	public Integer lesseeId;// 承租人表Lessee_id

	public String Identification;

	public String entAlias;// 客户别称

	public String industryCategory;// 行业分类

	public String mainBusiness;// 主要业务

	public String entWeb;// 企业网址

	public String entAbout;// 企业简介

	public String lesseeLevel;// 承租人级别

	public String employeeAmt;// 员工数量
	
	public Double outputValue;// 产值
	
	public Double ratal;// 纳税额
	
	public Double revenues;// 营收额
	
	public char isExhibition; // 是否有展厅

	public char isHighTech;// 是否认定国高

	public char isListedCompany;// 是否上市公司

	public char listedBlock;// 上市板块

	public String stockCode;// 股票代码

	public String archiveCode;// 客户档案编码

	public String archivePlace;// 档案存放位置

	public String mem;// 备注
//---------------------------------------------承租人
	public String creditCode;// 统一社会信用代码

	public String organizitionCode;// 组织机构代码

	public String enterpriseType;// 主体类型

	public String legalRepresentative;// 法定代表人

	public Date establishmentDate;// 成立时间
	//----------------------------------------法人
	public String phone;//联系人座机
	
	public String mobile;//联系人手机
	
	public String name;//联系人名字
	
	public String duty;//联系人职务
	
	public String email;//联系人邮箱
	
	public String rentPurpose;//房屋用途


	public CustomerServiceObject() {
		super();
	}

	public CustomerServiceObject(Integer rowSpan, String customerName, String contractCode, String projectName,
			String roomName, String buildingName, String industry, String customerLevel, String contactsName,
			Integer rowNum, Integer lesseeId, String identification, String entAlias, String industryCategory,
			String mainBusiness, String entWeb, String entAbout, String lesseeLevel, String employeeAmt,
			Double outputValue, Double ratal, Double revenues, char isExhibition, char isHighTech, char isListedCompany,
			char listedBlock, String stockCode, String archiveCode, String archivePlace, String mem, String creditCode,
			String organizitionCode, String enterpriseType, String legalRepresentative, Date establishmentDate,
			String phone, String mobile, String name, String duty, String email, String rentPurpose) {
		super();
		this.rowSpan = rowSpan;
		this.customerName = customerName;
		this.contractCode = contractCode;
		this.projectName = projectName;
		this.roomName = roomName;
		this.buildingName = buildingName;
		this.industry = industry;
		this.customerLevel = customerLevel;
		this.contactsName = contactsName;
		this.rowNum = rowNum;
		this.lesseeId = lesseeId;
		Identification = identification;
		this.entAlias = entAlias;
		this.industryCategory = industryCategory;
		this.mainBusiness = mainBusiness;
		this.entWeb = entWeb;
		this.entAbout = entAbout;
		this.lesseeLevel = lesseeLevel;
		this.employeeAmt = employeeAmt;
		this.outputValue = outputValue;
		this.ratal = ratal;
		this.revenues = revenues;
		this.isExhibition = isExhibition;
		this.isHighTech = isHighTech;
		this.isListedCompany = isListedCompany;
		this.listedBlock = listedBlock;
		this.stockCode = stockCode;
		this.archiveCode = archiveCode;
		this.archivePlace = archivePlace;
		this.mem = mem;
		this.creditCode = creditCode;
		this.organizitionCode = organizitionCode;
		this.enterpriseType = enterpriseType;
		this.legalRepresentative = legalRepresentative;
		this.establishmentDate = establishmentDate;
		this.phone = phone;
		this.mobile = mobile;
		this.name = name;
		this.duty = duty;
		this.email = email;
		this.rentPurpose = rentPurpose;
	}

	public Integer getChengzuId() {
		return chengzuId;
	}

	public void setChengzuId(Integer chengzuId) {
		this.chengzuId = chengzuId;
	}

	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getEntAlias() {
		return entAlias;
	}

	public void setEntAlias(String entAlias) {
		this.entAlias = entAlias;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public String getMainBusiness() {
		return mainBusiness;
	}

	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}

	public String getEntWeb() {
		return entWeb;
	}

	public void setEntWeb(String entWeb) {
		this.entWeb = entWeb;
	}

	public String getEntAbout() {
		return entAbout;
	}

	public void setEntAbout(String entAbout) {
		this.entAbout = entAbout;
	}

	public String getLesseeLevel() {
		return lesseeLevel;
	}

	public void setLesseeLevel(String lesseeLevel) {
		this.lesseeLevel = lesseeLevel;
	}

	public String getEmployeeAmt() {
		return employeeAmt;
	}

	public void setEmployeeAmt(String employeeAmt) {
		this.employeeAmt = employeeAmt;
	}

	public Double getOutputValue() {
		return outputValue;
	}

	public void setOutputValue(Double outputValue) {
		this.outputValue = outputValue;
	}

	public Double getRatal() {
		return ratal;
	}

	public void setRatal(Double ratal) {
		this.ratal = ratal;
	}

	public Double getRevenues() {
		return revenues;
	}

	public void setRevenues(Double revenues) {
		this.revenues = revenues;
	}

	public char getIsExhibition() {
		return isExhibition;
	}

	public void setIsExhibition(char isExhibition) {
		this.isExhibition = isExhibition;
	}

	public char getIsHighTech() {
		return isHighTech;
	}

	public void setIsHighTech(char isHighTech) {
		this.isHighTech = isHighTech;
	}

	public char getIsListedCompany() {
		return isListedCompany;
	}

	public void setIsListedCompany(char isListedCompany) {
		this.isListedCompany = isListedCompany;
	}

	public char getListedBlock() {
		return listedBlock;
	}

	public void setListedBlock(char listedBlock) {
		this.listedBlock = listedBlock;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getArchiveCode() {
		return archiveCode;
	}

	public void setArchiveCode(String archiveCode) {
		this.archiveCode = archiveCode;
	}

	public String getArchivePlace() {
		return archivePlace;
	}

	public void setArchivePlace(String archivePlace) {
		this.archivePlace = archivePlace;
	}

	public String getMem() {
		return mem;
	}

	public void setMem(String mem) {
		this.mem = mem;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getOrganizitionCode() {
		return organizitionCode;
	}

	public void setOrganizitionCode(String organizitionCode) {
		this.organizitionCode = organizitionCode;
	}



	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRentPurpose() {
		return rentPurpose;
	}

	public void setRentPurpose(String rentPurpose) {
		this.rentPurpose = rentPurpose;
	}

	public Integer getLesseeId() {
		return lesseeId;
	}

	public void setLesseeId(Integer lesseeId) {
		this.lesseeId = lesseeId;
	}

	public String getIdentification() {
		return Identification;
	}

	public void setIdentification(String identification) {
		Identification = identification;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getRowSpan() {
		return rowSpan;
	}

	public void setRowSpan(Integer rowSpan) {
		this.rowSpan = rowSpan;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(String customerLevel) {
		this.customerLevel = customerLevel;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

}
