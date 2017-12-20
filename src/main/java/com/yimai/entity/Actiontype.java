package com.yimai.entity;

public class Actiontype {
    private Integer tenantid;

    private String name;

    private Integer id;

    private Boolean hasvalue;

    private Integer weight;

    public Integer getTenantid() {
        return tenantid;
    }

    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHasvalue() {
        return hasvalue;
    }

    public void setHasvalue(Boolean hasvalue) {
        this.hasvalue = hasvalue;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}