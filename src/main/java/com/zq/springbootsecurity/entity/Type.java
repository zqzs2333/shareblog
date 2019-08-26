package com.zq.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author makejava
 * @since 2019-08-26 09:23:48
 */
public class Type implements Serializable {
    private static final long serialVersionUID = -47072001566112539L;
    
    private Integer id;
    //分类名称
    private String typeName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}