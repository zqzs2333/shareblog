package com.zq.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2019-08-20 09:53:21
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -76708001100129063L;
    
    private Integer userId;
    
    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}