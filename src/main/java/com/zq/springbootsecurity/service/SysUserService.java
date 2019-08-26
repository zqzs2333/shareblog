package com.zq.springbootsecurity.service;


import com.zq.springbootsecurity.entity.SysUser;
import com.zq.springbootsecurity.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }

    public void insert(SysUser sysUser)
    {
        userMapper.insert(sysUser);
    }

}
