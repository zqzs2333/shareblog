package com.zq.springbootsecurity.dao;

import com.zq.springbootsecurity.entity.SysUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchCrudRepository<SysUser,Integer> {
public List<SysUser> findByNameLike(String name);
}
