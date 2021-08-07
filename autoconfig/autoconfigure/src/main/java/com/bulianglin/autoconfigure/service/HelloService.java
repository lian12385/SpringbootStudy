package com.bulianglin.autoconfigure.service;

import com.bulianglin.autoconfigure.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {
    @Autowired
    HelloProperties helloProperties;


    public String sayHello(String username){
        return helloProperties.getPrefix() + ":" + username + ">>" + helloProperties.getSuffic();
    }
}
