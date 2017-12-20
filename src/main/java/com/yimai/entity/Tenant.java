package com.yimai.entity;

import java.util.Date;

public class Tenant {
    private Integer id;

    private String stringid;

    private String description;

    private Integer ratingrangemin;

    private Integer ratingrangemax;

    private Double ratingrangeneutral;

    private Boolean active;

    private String operatorid;

    private String url;

    private Date creationdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStringid() {
        return stringid;
    }

    public void setStringid(String stringid) {
        this.stringid = stringid == null ? null : stringid.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getRatingrangemin() {
        return ratingrangemin;
    }

    public void setRatingrangemin(Integer ratingrangemin) {
        this.ratingrangemin = ratingrangemin;
    }

    public Integer getRatingrangemax() {
        return ratingrangemax;
    }

    public void setRatingrangemax(Integer ratingrangemax) {
        this.ratingrangemax = ratingrangemax;
    }

    public Double getRatingrangeneutral() {
        return ratingrangeneutral;
    }

    public void setRatingrangeneutral(Double ratingrangeneutral) {
        this.ratingrangeneutral = ratingrangeneutral;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid == null ? null : operatorid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }
}