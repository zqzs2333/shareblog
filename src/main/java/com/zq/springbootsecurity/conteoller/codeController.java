package com.zq.springbootsecurity.conteoller;

import com.zq.springbootsecurity.entity.SysUser;
import com.zq.springbootsecurity.service.MailService;
import com.zq.springbootsecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class codeController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    MailService mailService;
    @RequestMapping("/code")
    @ResponseBody
    public void sendMail(@RequestParam(value = "mail" ,required=true) String mail)
    {
   mailService.sendMail(mail);
//if (code.equals(String.valueOf(mailService.getCode())))
//{
//sysUserService.insert();
//}
    }
    @PostMapping("/registered")
    public String registered( @RequestParam("code") String code, SysUser sysUser)
    {
      SysUser user=  sysUserService.selectByName(sysUser.getName());


        if (code.equals(String.valueOf(mailService.getCode())) && user != null )
{
sysUserService.insert(sysUser);
}
        else if(! code.equals(String.valueOf(mailService.getCode())))
        {
            throw new BadCredentialsException("邮箱验证码错误！");
        }
        else if (user ==null)
        {
            throw new BadCredentialsException("用户已经存在！");
        }
        return "redirect:/login";

    }
}
