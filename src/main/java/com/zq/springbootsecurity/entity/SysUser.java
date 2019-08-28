package com.zq.springbootsecurity.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2019-08-20 09:53:08
 */
@Document(indexName = "share",type = "user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 112537130698984726L;

    @Id
    private Integer id;
    
    private String name;
    
    private String password;

    private Integer code;
    private String mail;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;


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

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", code=" + code +
                ", mail='" + mail + '\'' +
                ", status=" + status +
                '}';
    }
}