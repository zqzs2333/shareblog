package com.zq.springbootsecurity;

import com.zq.springbootsecurity.entity.Type;
import com.zq.springbootsecurity.service.MailService;
import com.zq.springbootsecurity.service.TypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSecurityApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    TypeService typeService;

    @Autowired
    MailService mailService;
    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("928843846@qq.com");
        message.setTo("798136670@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }

    @Test
    public void  setMail() throws  Exception
    {
        Type t1 =new Type();
        t1.setId(2);
        t1.setTypeName("音乐");
        typeService.insert(t1);

    }




}
