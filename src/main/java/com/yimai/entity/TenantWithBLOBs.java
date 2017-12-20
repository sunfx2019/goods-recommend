package com.yimai.entity;

public class TenantWithBLOBs extends Tenant {
    private byte[] tenantconfig;

    private byte[] tenantstatistic;

    public byte[] getTenantconfig() {
        return tenantconfig;
    }

    public void setTenantconfig(byte[] tenantconfig) {
        this.tenantconfig = tenantconfig;
    }

    public byte[] getTenantstatistic() {
        return tenantstatistic;
    }

    public void setTenantstatistic(byte[] tenantstatistic) {
        this.tenantstatistic = tenantstatistic;
    }
}