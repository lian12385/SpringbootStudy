package com.bulianglin.thymeleafspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bulianglin.thymeleafspringboot.bean.User;
import com.bulianglin.thymeleafspringboot.mapper.UserMapper;
import com.bulianglin.thymeleafspringboot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
