package com.zq.springbootsecurity.mapper;

import com.zq.springbootsecurity.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TypeMapper {

    Type queryById(Integer id);

    @Select("select * from type where type_name = #{name}")
    Type selectName(String name);


    @Select("select * from type")
    List<Type> selectAll();

    @Select("SELECT count(type.type_name)\n" +
            "FROM blog,type\n" +
            "WHERE blog.type_id=type.id AND type.type_name= #{typename}")
    int counttype(String typename);


    int update(Type type);
    int insert(Type type);
    int deleteById(Integer id);
}
