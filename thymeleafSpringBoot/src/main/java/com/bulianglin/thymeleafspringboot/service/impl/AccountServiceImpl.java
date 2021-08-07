package com.bulianglin.thymeleafspringboot.service.impl;

import com.bulianglin.thymeleafspringboot.bean.Account;
import com.bulianglin.thymeleafspringboot.mapper.AccountMapper;
import com.bulianglin.thymeleafspringboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    public Account getbyid(Long id){
        return accountMapper.getAcc(id);
    }

}
