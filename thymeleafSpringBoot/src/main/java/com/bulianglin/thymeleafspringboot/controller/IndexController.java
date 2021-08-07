package com.bulianglin.thymeleafspringboot.controller;

import com.bulianglin.thymeleafspringboot.bean.Account;
import com.bulianglin.thymeleafspringboot.bean.City;
import com.bulianglin.thymeleafspringboot.bean.User;
import com.bulianglin.thymeleafspringboot.service.AccountService;
import com.bulianglin.thymeleafspringboot.service.CityService;
import com.bulianglin.thymeleafspringboot.service.UserService;
import com.bulianglin.thymeleafspringboot.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityService cityService;

    @Autowired
    AccountService accountService;

    @Autowired
    UserService userService;

    //@Autowired
    RedisTemplate redisTemplate;


    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }



    @ResponseBody
    @GetMapping("/acc")
    public Account getbyid(@RequestParam("id") Long id){
        return accountService.getbyid(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl",Long.class);
        return aLong.toString();
    }


    @GetMapping(value = { "/", "/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUserName())&&"root".equals(user.getUserPassword())){
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg","账号或密码错误！");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(){
        log.info("当前方法是：{}","mainPage");

        //ValueOperations<String, String> operations= redisTemplate.opsForValue();
        //String s = operations.get("/main.html");
        //String s1 = operations.get("/sql");
        return "main";
    }

}
