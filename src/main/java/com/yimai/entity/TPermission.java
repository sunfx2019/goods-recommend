package com.yimai.entity;

public class TPermission {
    /**
     * 
     */
    private Long id;

    /**
     * url地址
     */
    private String url;

    /**
     * url描述
     */
    private String name;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * url地址
     * @return url url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * url地址
     * @param url url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * url描述
     * @return name url描述
     */
    public String getName() {
        return name;
    }

    /**
     * url描述
     * @param name url描述
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}