package com.zq.springbootsecurity.conteoller;

import com.alipay.api.AlipayApiException;
import com.zq.springbootsecurity.service.OrdersService;
import com.zq.springbootsecurity.util.codeutil;
import com.zq.springbootsecurity.entity.SysUser;
import com.zq.springbootsecurity.service.MailService;
import com.zq.springbootsecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    MailService mailService;
    @Autowired
    OrdersService ordersService;


    @RequestMapping(value = "/register")
    public String register(SysUser sysUser, Model model)
    {
        SysUser user = sysUserService.selectByName(sysUser.getName());
        SysUser user1 = sysUserService.selectByMail(sysUser.getMail());
        if (user ==null && user1 ==null) {
            codeutil Codeutil = new codeutil();
            sysUser.setStatus(0);
            int activeCode = Codeutil.getCode();
            sysUser.setCode(activeCode);
            sysUserService.insert(sysUser);
        }
        else if(user != null)
        {
            model.addAttribute("msg","用户名已存在");
            return "registered";
        }
        else if (user1 != null)
        {
            model.addAttribute("msg","邮箱已存在");
            return "registered";
        }
        return "activeSuccess";
    }

    @RequestMapping(value = "/checkCode")
    public String checkCode(String code){
        SysUser sysUser = sysUserService.selectBycode(code);
        //如果用户不等于null，把用户状态修改status=1
        if (sysUser !=null){
            sysUser.setStatus(1);
            //把code验证码清空，已经不需要了
            sysUser.setCode(null);
            sysUserService.update(sysUser);

            return "home";
        }

        return "login";
    }

    @RequestMapping("/ali")
    public void ali(HttpServletResponse response, HttpServletRequest request) throws IOException, AlipayApiException {
        ordersService.ali(response,request);
    }

    @RequestMapping("/toa")
    public String toa()
    {
        return "ali";
    }

}
