package com.zq.springbootsecurity.service;

import com.zq.springbootsecurity.entity.SysRole;
import com.zq.springbootsecurity.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}