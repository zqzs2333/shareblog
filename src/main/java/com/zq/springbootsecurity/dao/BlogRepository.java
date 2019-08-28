package com.zq.springbootsecurity.dao;

import com.zq.springbootsecurity.entity.Blog;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface BlogRepository extends ElasticsearchCrudRepository<Blog,Integer> {
    public List<Blog> findByBlogTitleLike(String titlename);
}
