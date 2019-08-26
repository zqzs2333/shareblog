package com.zq.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2019-08-20 09:52:40
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 784011324213905586L;
    
    private Integer id;
    
    private String name;


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

}