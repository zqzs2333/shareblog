package com.zq.springbootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Random;

@Service
public class MailService  {

    @Autowired
    private JavaMailSender mailSender;

    //邮件发件人
    @Value("${mail.fromMail.addr}")
    private String from;

    @Autowired
    TemplateEngine templateEngine;

    Random ne=new Random();//实例化一个random的对象ne
    int x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
    public String getCode()
    {
        return String.valueOf(x);
    }


    public void sendMail(String to) {

        String subject="验证码";
        String mailVerifyCode =String.valueOf(x);
        //创建邮件正文
//        Context context = new Context();
//        context.setVariable("mailVerifyCode", "您的验证码是："+mailVerifyCode);//页面获取[[${mailVerifyCode}]]
//        //将模块引擎内容解析成html字符串
//        String emailContent = templateEngine.process("emailTemplate", context);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(mailVerifyCode);
        try {
            mailSender.send(message);
            //logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            //logger.error("发送简单邮件时发生异常！", e);
        }
    }

}