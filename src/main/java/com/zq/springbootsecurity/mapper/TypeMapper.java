package com.zq.springbootsecurity.mapper;

import com.zq.springbootsecurity.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {

    Type queryById(Integer id);

    @Select("select * from type where tpye_name = #{name}")
    Type selectName(String name);

    @Select("select * from type")
    List<Type> selectAll();


    int update(Type type);
    int insert(Type type);
    int deleteById(Integer id);
}
