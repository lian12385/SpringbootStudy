package com.example.test.controller;

import com.bulianglin.autoconfigure.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
        @Autowired
        HelloService helloService;

        @GetMapping("/hello")
        public String sayHello(){
            String s = helloService.sayHello("zhangsan");
            return s;
        }
}
