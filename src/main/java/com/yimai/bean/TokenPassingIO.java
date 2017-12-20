package com.yimai.bean;

import java.util.Date;

public class TokenPassingIO {
	
	public Integer tokenId;//令牌ID
	
	public Integer trasitionInfoId;//迁越信息ID
	
	public String type;//类型，代表的是令牌的失效还是生效
	
	public Date createTime;//创建时间

	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}


	public Integer getTrasitionInfoId() {
		return trasitionInfoId;
	}

	public void setTrasitionInfoId(Integer trasitionInfoId) {
		this.trasitionInfoId = trasitionInfoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
