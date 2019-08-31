package com.zq.springbootsecurity.conteoller;

import com.zq.springbootsecurity.dao.BlogRepository;
import com.zq.springbootsecurity.dao.UserRepository;
import com.zq.springbootsecurity.entity.Blog;
import com.zq.springbootsecurity.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class Searchcontroller {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BlogRepository blogRepository;
    @PostMapping("/searchtitle")
    public String searchtitle(@RequestParam("search") String search, Model model, HttpServletRequest request, HttpServletResponse response)
    {
        List<Blog> blogs = blogRepository.findByBlogTitleLike(search);
        model.addAttribute("blogs",blogs);
        request.getSession().setAttribute("search",search);
        return  "search";
    }
    @RequestMapping("/searchuser")
    public  String searchuser(Model model, HttpServletRequest request, HttpServletResponse response)
    {
        String search = (String) request.getSession().getAttribute("search");
        List<SysUser> users = userRepository.findByNameLike(search);
        model.addAttribute("users",users);
        return  "search";
    }
}
