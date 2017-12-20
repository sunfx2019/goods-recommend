package com.yimai.entity;

import java.util.Date;

public class Action {
    private Long id;

    private Integer tenantid;

    private Integer userid;

    private String sessionid;

    private String ip;

    private Integer itemid;

    private Integer itemtypeid;

    private Integer actiontypeid;

    private Integer ratingvalue;

    private String actioninfo;

    private Date actiontime;

    private Integer isUse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTenantid() {
        return tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? null : sessionid.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getItemtypeid() {
        return itemtypeid;
    }

    public void setItemtypeid(Integer itemtypeid) {
        this.itemtypeid = itemtypeid;
    }

    public Integer getActiontypeid() {
        return actiontypeid;
    }

    public void setActiontypeid(Integer actiontypeid) {
        this.actiontypeid = actiontypeid;
    }

    public Integer getRatingvalue() {
        return ratingvalue;
    }

    public void setRatingvalue(Integer ratingvalue) {
        this.ratingvalue = ratingvalue;
    }

    public String getActioninfo() {
        return actioninfo;
    }

    public void setActioninfo(String actioninfo) {
        this.actioninfo = actioninfo == null ? null : actioninfo.trim();
    }

    public Date getActiontime() {
        return actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
}