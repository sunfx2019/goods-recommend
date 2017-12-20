package com.yimai.bean;

import java.util.Date;

public class DataDictionaryObject {
	
	public String DICT_NAME;//名称
	
	public Integer OPERATOR;//操作人
	
	public Date CREATE_TIME;//创建时间
	
	public String RECORD_STATUS;//有效状态
	
	public String DICT_CODE;//当前字典编码
	
	public String PDC;//父字典编码
	
	public Integer LEVEL;//等级

	public String getDICT_NAME() {
		return DICT_NAME;
	}

	public void setDICT_NAME(String dICT_NAME) {
		DICT_NAME = dICT_NAME;
	}

	public Integer getOPERATOR() {
		return OPERATOR;
	}

	public void setOPERATOR(Integer oPERATOR) {
		OPERATOR = oPERATOR;
	}

	public Date getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(Date cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}

	public String getRECORD_STATUS() {
		return RECORD_STATUS;
	}

	public void setRECORD_STATUS(String rECORD_STATUS) {
		RECORD_STATUS = rECORD_STATUS;
	}

	public String getDICT_CODE() {
		return DICT_CODE;
	}

	public void setDICT_CODE(String dICT_CODE) {
		DICT_CODE = dICT_CODE;
	}

	public String getPDC() {
		return PDC;
	}

	public void setPDC(String pDC) {
		PDC = pDC;
	}

	public Integer getLEVEL() {
		return LEVEL;
	}

	public void setLEVEL(Integer lEVEL) {
		LEVEL = lEVEL;
	}
	
	

}
