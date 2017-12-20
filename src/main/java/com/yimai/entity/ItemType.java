package com.yimai.entity;

public class ItemType {
    private Integer tenantid;

    private String name;

    private long id;

    private Boolean visible;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}