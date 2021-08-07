package com.bulianglin.thymeleafspringboot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bulianglin.thymeleafspringboot.bean.User;
import com.bulianglin.thymeleafspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        //List<User> list = userService.list();


        Page<User> page = new Page<>(pn,1);

        Page<User> userPage = userService.page(page,null);
        //long current = page.getCurrent();
        //long pages = page.getPages();
        //long total = page.getTotal();
        model.addAttribute("users",userPage);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }


    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }



}
