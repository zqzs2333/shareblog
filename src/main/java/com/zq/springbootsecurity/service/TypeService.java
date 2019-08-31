package com.zq.springbootsecurity.service;

import com.zq.springbootsecurity.entity.Type;
import com.zq.springbootsecurity.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeMapper typeMapper;

   public Type queryById(Integer id)
    {
     return    typeMapper.queryById(id);
    }
    public  Type selectByName(String name)
    {
        return typeMapper.selectName(name);
    }

    public List<Type> selectAll()
    {
        return typeMapper.selectAll();
    }

    public  void  update(Type type)
    {
        typeMapper.update(type);
    }
    public void insert(Type type)
    {
        typeMapper.insert(type);
    }
    public void  deleteById(Integer id){
        typeMapper.deleteById(id);
    }

    public int counttype(String typename)
    {
      return   typeMapper.counttype(typename);
    }
}
