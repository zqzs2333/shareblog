package com.zq.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2019-08-20 09:53:08
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 112537130698984726L;
    
    private Integer id;
    
    private String name;
    
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}