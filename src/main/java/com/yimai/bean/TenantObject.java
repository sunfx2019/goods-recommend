package com.yimai.bean;

import java.util.Date;

public class TenantObject {
	/*
	承租人类型--          Tenant type   --        LESSEE_TYPE
	企业名称--          Enterprise name   --      法人表  
	企业别称--          Business alias   --        ENT_ALIAS
	企业网址--          Enterprise URL   --        ENT_WEB
	入住员工数量--       Number of employees  --     EMPLOYEE_AMT    
	行业分类--          Industry classification   --    INDUSTRY_CATEGORY--数据字典    
	主要业务--          Main business   --        MAIN_BUSINESS
	企业简介--          Company profile   --       ENT_ABOUT 
	财务状况--          Financial position   --        
	是否有展厅--          exhibition   --      IS_EXHIBITION  
	认定国高--          In high   --        IS_HIGH_TECH
	是否上市--          isList   --        IS_LISTED_COMPANY
	上市板块--          Listed sector   --       LISTED_BLOCK 
	股票代码--          Stock code   --        STOCK_CODE
	客户级别--          Customer level   --       LESSEE_LEVEL 
	配套类型--          Matching type   --        MATING_TYPE
	客户档案编号--        Customer file number    --    ARCHIVE_CODE    
	档案存放位置--          File location   --        ARCHIVE_PLACE
	备注--          Remarks ----   MEM*/
	
	public Integer LESSEE_ID;
	
	public String cName;
	
	public String LESSEE_TYPE;
	
	public String ENTERPRISE_NAME;
	
	public String ENT_ALIAS;
	
	public String ENT_WEB;
	
	public Integer EMPLOYEE_AMT;
	
	public String  MAIN_BUSINESS;
	
	public String  ENT_ABOUT;
	
	public String IS_EXHIBITION;
	
	public String IS_HIGH_TECH;
	
	public String IS_LISTED_COMPANY;
	
	public String LISTED_BLOCK;
	
	public String STOCK_CODE;
	
	public String LESSEE_LEVEL;
	
	public String MATING_TYPE;
	
	public String ARCHIVE_CODE;
	
	public String ARCHIVE_PLACE;
	
	public String REMARKS;
	
	public String INDUSTRY_CATEGORY;
	
	public Integer OUTPUT_VALUE;
	
	public Integer RATAL;
	
	public Integer REVENUES;
	
	public Date ANNUAL;
	
	public String  year;
	
	public Integer peopleId;
	
	public Integer ANNUALID;
	
	
	
	public Integer getANNUALID() {
		return ANNUALID;
	}

	public void setANNUALID(Integer aNNUALID) {
		ANNUALID = aNNUALID;
	}

	public Integer getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(Integer peopleId) {
		this.peopleId = peopleId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getLESSEE_ID() {
		return LESSEE_ID;
	}

	public void setLESSEE_ID(Integer lESSEE_ID) {
		LESSEE_ID = lESSEE_ID;
	}

	public String getLESSEE_TYPE() {
		return LESSEE_TYPE;
	}

	public void setLESSEE_TYPE(String lESSEE_TYPE) {
		LESSEE_TYPE = lESSEE_TYPE;
	}

	public String getENTERPRISE_NAME() {
		return ENTERPRISE_NAME;
	}

	public void setENTERPRISE_NAME(String eNTERPRISE_NAME) {
		ENTERPRISE_NAME = eNTERPRISE_NAME;
	}

	public String getENT_ALIAS() {
		return ENT_ALIAS;
	}

	public void setENT_ALIAS(String eNT_ALIAS) {
		ENT_ALIAS = eNT_ALIAS;
	}

	public String getENT_WEB() {
		return ENT_WEB;
	}

	public void setENT_WEB(String eNT_WEB) {
		ENT_WEB = eNT_WEB;
	}

	public Integer getEMPLOYEE_AMT() {
		return EMPLOYEE_AMT;
	}

	public void setEMPLOYEE_AMT(Integer eMPLOYEE_AMT) {
		EMPLOYEE_AMT = eMPLOYEE_AMT;
	}

	public String getMAIN_BUSINESS() {
		return MAIN_BUSINESS;
	}

	public void setMAIN_BUSINESS(String mAIN_BUSINESS) {
		MAIN_BUSINESS = mAIN_BUSINESS;
	}

	public String getENT_ABOUT() {
		return ENT_ABOUT;
	}

	public void setENT_ABOUT(String eNT_ABOUT) {
		ENT_ABOUT = eNT_ABOUT;
	}

	public String getIS_EXHIBITION() {
		return IS_EXHIBITION;
	}

	public void setIS_EXHIBITION(String iS_EXHIBITION) {
		IS_EXHIBITION = iS_EXHIBITION;
	}

	public String getIS_HIGH_TECH() {
		return IS_HIGH_TECH;
	}

	public void setIS_HIGH_TECH(String iS_HIGH_TECH) {
		IS_HIGH_TECH = iS_HIGH_TECH;
	}

	public String getIS_LISTED_COMPANY() {
		return IS_LISTED_COMPANY;
	}

	public void setIS_LISTED_COMPANY(String iS_LISTED_COMPANY) {
		IS_LISTED_COMPANY = iS_LISTED_COMPANY;
	}

	public String getLISTED_BLOCK() {
		return LISTED_BLOCK;
	}

	public void setLISTED_BLOCK(String lISTED_BLOCK) {
		LISTED_BLOCK = lISTED_BLOCK;
	}

	public String getSTOCK_CODE() {
		return STOCK_CODE;
	}

	public void setSTOCK_CODE(String sTOCK_CODE) {
		STOCK_CODE = sTOCK_CODE;
	}

	public String getLESSEE_LEVEL() {
		return LESSEE_LEVEL;
	}

	public void setLESSEE_LEVEL(String lESSEE_LEVEL) {
		LESSEE_LEVEL = lESSEE_LEVEL;
	}

	public String getMATING_TYPE() {
		return MATING_TYPE;
	}

	public void setMATING_TYPE(String mATING_TYPE) {
		MATING_TYPE = mATING_TYPE;
	}

	public String getARCHIVE_CODE() {
		return ARCHIVE_CODE;
	}

	public void setARCHIVE_CODE(String aRCHIVE_CODE) {
		ARCHIVE_CODE = aRCHIVE_CODE;
	}

	public String getARCHIVE_PLACE() {
		return ARCHIVE_PLACE;
	}

	public void setARCHIVE_PLACE(String aRCHIVE_PLACE) {
		ARCHIVE_PLACE = aRCHIVE_PLACE;
	}

	public String getREMARKS() {
		return REMARKS;
	}

	public void setREMARKS(String rEMARKS) {
		REMARKS = rEMARKS;
	}

	public String getINDUSTRY_CATEGORY() {
		return INDUSTRY_CATEGORY;
	}

	public void setINDUSTRY_CATEGORY(String iNDUSTRY_CATEGORY) {
		INDUSTRY_CATEGORY = iNDUSTRY_CATEGORY;
	}

	public Integer getOUTPUT_VALUE() {
		return OUTPUT_VALUE;
	}

	public void setOUTPUT_VALUE(Integer oUTPUT_VALUE) {
		OUTPUT_VALUE = oUTPUT_VALUE;
	}

	public Integer getRATAL() {
		return RATAL;
	}

	public void setRATAL(Integer rATAL) {
		RATAL = rATAL;
	}

	public Integer getREVENUES() {
		return REVENUES;
	}

	public void setREVENUES(Integer rEVENUES) {
		REVENUES = rEVENUES;
	}

	public Date getANNUAL() {
		return ANNUAL;
	}

	public void setANNUAL(Date aNNUAL) {
		ANNUAL = aNNUAL;
	}

	
	
}
