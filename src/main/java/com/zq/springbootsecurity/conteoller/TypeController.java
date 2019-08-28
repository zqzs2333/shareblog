package com.zq.springbootsecurity.conteoller;

import com.zq.springbootsecurity.entity.Type;
import com.zq.springbootsecurity.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String AddType( Type type)
    {
        System.out.println(type);
        Type type1 = typeService.selectByName(type.getTypeName());
        if (type1 != null)
        {
            throw new BadCredentialsException("分类已存在！");
        }
        else
        {
            System.out.println("保存的分类"+type);
            typeService.insert(type);
            return "redirect:/types";
        }


    }
    @GetMapping("/type/delete/{id}")
    public String deletetype(@PathVariable("id") Integer id)

    {
        typeService.deleteById(id);
        return "redirect:/types";
    }

    @GetMapping("/type/{id}")
    public String totypechange(@PathVariable("id") Integer id,Model model )
    {
        Type type = typeService.queryById(id);
        model.addAttribute("type",type);
        return "type-change";
    }

    @PutMapping("/type/{id}")
    public String typechange(@PathVariable("id") Integer id, @RequestParam("typeName") String name,Model model)
    {
        Type type = typeService.queryById(id);


        if (typeService.selectByName(name) != null)
        {
            model.addAttribute("msg","已存在该分类");
        }
        else
        {
            type.setTypeName(name);
            typeService.update(type);
            model.addAttribute("msg","修改成功");

        }
        return "redirect:/types";
    }
}
