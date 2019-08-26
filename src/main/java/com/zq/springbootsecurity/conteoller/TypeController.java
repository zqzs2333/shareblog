package com.zq.springbootsecurity.conteoller;

import com.zq.springbootsecurity.entity.Type;
import com.zq.springbootsecurity.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @GetMapping("/types")
    public String TypeList(Model model)
    {

        List<Type> types = typeService.selectAll();
        model.addAttribute("types",types);
        return "type";
    }


    @RequestMapping("/totypeadd")
    public  String toAddType()
    {
        return "type-input";
    }

    @PostMapping("/type")
    public String AddType(Type type)
    {
        System.out.println("保存的分类"+type);
        typeService.insert(type);
        return "redirect:/types";
    }

}
