package com.zq.springbootsecurity.service;


import com.zq.springbootsecurity.entity.SysUser;
import com.zq.springbootsecurity.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    MailService mailService;

    public SysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return sysUserMapper.selectByName(name);
    }

    public void insert(SysUser sysUser)
    {
        sysUserMapper.insert(sysUser);
        //获取激活码
        int code = sysUser.getCode();
        System.out.println("激活码:"+code);
        //主题
        String subject = "来自share me的激活邮件";
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=\"http://localhost:8080/checkCode?code="+code+"\">激活请点击</a>";
        //发送激活邮件
        mailService.sendMail(sysUser.getMail(),subject,context);


    }
    public SysUser selectBycode(String code)
    {
        return sysUserMapper.selectBycode(code);
    }
    public  void  update(SysUser sysUser)
    {
        sysUserMapper.update(sysUser);
    }

}
