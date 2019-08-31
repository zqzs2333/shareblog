package com.zq.springbootsecurity;

import com.zq.springbootsecurity.dao.BlogRepository;
import com.zq.springbootsecurity.dao.UserRepository;
import com.zq.springbootsecurity.entity.Blog;
import com.zq.springbootsecurity.entity.SysUser;
import com.zq.springbootsecurity.entity.Type;
import com.zq.springbootsecurity.service.MailService;
import com.zq.springbootsecurity.service.SysUserService;
import com.zq.springbootsecurity.service.TypeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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
    BlogRepository blogRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public   void  y1() throws Exception
    {
        SysUser sysUser = new SysUser();
        sysUser.setId(2);
        sysUser.setName("haha");
        sysUser.setMail("798@qq.com");
        sysUser.setPassword("12312");
        userRepository.save(sysUser);
//        Blog blog = new Blog();
//        blog.setTypeId(2);
//        blog.setBlogTitle("今天也是美美的一天");
//        blog.setBlogContext("sadas");
//        blog.setBlogId(1);
//        Blog blog1 = new Blog();
//        blog1.setBlogId(2);
//        blog1.setBlogTitle("美美");
//        blogRepository.save(blog);
//        blogRepository.save(blog1);
//        for (SysUser user : userRepository.findByNameLike("ad")) {
//            System.out.println(user);
//        }

//        for (Blog blog : blogRepository.findByBlogTitleLike("美美")) {
//            System.out.println(blog);
//        }

        }

    @Autowired
    TypeService typeService;

    @Autowired
    MailService mailService;

    @Autowired
    SysUserService sysUserService;
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
    public  void  pay() throws Exception
    {
        sysUserService.pay("admin","zqq",5);
    }
    @Test
    public void  setMail() throws  Exception
    {
        int i = typeService.counttype("生活");
        System.out.println(i);
    }
//    @Test
//    public void index(){
//
//        Blog article = new Blog();
//        article.setBlogId(1);
//        article.setAuthorId(1);
//      article.setTypeId(2);
//      article.setBlogTitle("xinwen");
//      article.setBlogContext("test");
//        //构建一个索引功能，类型为news
//        Index index = new Index.Builder(article).index("shareme").type("blogs").build();
//
//        try {
//            jestClient.execute(index);
//            System.out.println("数据索引成功！");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    @Test
//    public void search(){
//        //查询表达式
//        String json = "{\n" +
//                "    \"query\" : {\n" +
//                "        \"match\" : {\n" +
//                "            \"content\" : \"hello\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//        //构建搜索功能
//        Search search = new Search.Builder(json).addIndex("shareme").addType("blogs").build();
//
//        try {
//            SearchResult result = jestClient.execute(search);
//            System.out.println(result.getJsonString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }




