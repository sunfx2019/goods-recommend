package com.yimai.entity;

import java.util.Date;

public class TUser {
    /**
     * 
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 邮箱|登录帐号
     */
    private String email;

    /**
     * 密码
     */
    private String pswd;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 1:有效，0:禁止登录
     */
    private Long status;

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
     * 用户昵称
     * @return nickname 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 用户昵称
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 邮箱|登录帐号
     * @return email 邮箱|登录帐号
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱|登录帐号
     * @param email 邮箱|登录帐号
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 密码
     * @return pswd 密码
     */
    public String getPswd() {
        return pswd;
    }

    /**
     * 密码
     * @param pswd 密码
     */
    public void setPswd(String pswd) {
        this.pswd = pswd == null ? null : pswd.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后登录时间
     * @return last_login_time 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 最后登录时间
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 1:有效，0:禁止登录
     * @return status 1:有效，0:禁止登录
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 1:有效，0:禁止登录
     * @param status 1:有效，0:禁止登录
     */
    public void setStatus(Long status) {
        this.status = status;
    }
}