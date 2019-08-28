package com.zq.springbootsecurity.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.lang.annotation.Documented;
import java.util.Date;
import java.io.Serializable;

/**
 * (Blog)实体类
 *
 * @author makejava
 * @since 2019-08-28 09:52:39
 */

@Document(indexName = "shareme",type = "blogs")
public class Blog implements Serializable {
    private static final long serialVersionUID = 237444827165263916L;

    @Id
    private Integer blogId;
    
    private String blogTitle;
    
    private String blogContext;
    
    private Integer authorId;
    
    private Date createTime;
    
    private Integer typeId;
    
    private String image;


    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContext() {
        return blogContext;
    }

    public void setBlogContext(String blogContext) {
        this.blogContext = blogContext;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogContext='" + blogContext + '\'' +
                ", authorId=" + authorId +
                ", createTime=" + createTime +
                ", typeId=" + typeId +
                ", image='" + image + '\'' +
                '}';
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}