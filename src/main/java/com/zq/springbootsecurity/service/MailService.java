package com.zq.springbootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
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



    public void sendMail(String to, String subject, String content) {



        //创建邮件正文
//        Context context = new Context();
//        context.setVariable("mailVerifyCode", "您的验证码是："+mailVerifyCode);//页面获取[[${mailVerifyCode}]]
//        //将模块引擎内容解析成html字符串
//        String emailContent = templateEngine.process("emailTemplate", context);
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(content);
        try {
            MimeMessage message=mailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            //logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            //logger.error("发送简单邮件时发生异常！", e);
        }
    }

}