package com.zq.springbootsecurity;

import com.zq.springbootsecurity.service.MailService;
import com.zq.springbootsecurity.util.VerifyServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityApplication.class, args);
    }
    /**
     * 注入验证码servlet
     */

    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }


}
