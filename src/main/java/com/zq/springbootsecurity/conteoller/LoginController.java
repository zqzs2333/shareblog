package com.zq.springbootsecurity.conteoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);//日志打印

    @RequestMapping("/")
    public String showHome() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();//登入的用户的名字

        logger.info("当前登陆用户：" + name);


        return "home";
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/tor")
    public String tori()
    {
        return "registered";
    }

    @RequestMapping("/admin")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String printAdmin() {
        return "如果你看见这句话，说明你有ROLE_ADMIN角色";
    }

    @RequestMapping("/user")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_USER')")
    public String printUser() {
        return "如果你看见这句话，说明你有ROLE_USER角色";
    }

//    @RequestMapping("/login/error")
//    public void loginError(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html;charset=utf-8");
//        AuthenticationException exception =
//                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
//        try {
//            response.getWriter().write(exception.toString());
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        request.setAttribute("msg","Account password error!");
        AuthenticationException exception =
                (AuthenticationException)request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        try {
            response.getWriter().write(exception.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
