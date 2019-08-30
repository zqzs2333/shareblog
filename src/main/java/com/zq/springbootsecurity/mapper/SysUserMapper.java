package com.zq.springbootsecurity.mapper;

import com.zq.springbootsecurity.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

@Mapper
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);

    @Select("SELECT * FROM sys_user WHERE mail = #{mail}")
    SysUser selectByMail(String mail);

    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);

    @Select("select * from sys_user where code = #{code}")
    SysUser selectBycode(String code);

    @Update("UPDATE sys_user SET money=money-#{money} WHERE name=#{name}")
    void updatedec(Integer money,String name);
    @Update("UPDATE sys_user SET money=money+#{money} WHERE name=#{name}")
    void updateadd(Integer money,String name);



    void  insert(SysUser sysUser);
 void update(SysUser sysUser);

}
