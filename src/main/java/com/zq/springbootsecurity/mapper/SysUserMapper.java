package com.zq.springbootsecurity.mapper;

import com.zq.springbootsecurity.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);

    @Select("select * from sys_user where code = #{code}")
    SysUser selectBycode(String code);

    void  insert(SysUser sysUser);
 void update(SysUser sysUser);

}
