package com.bulianglin.thymeleafspringboot.service;

import com.bulianglin.thymeleafspringboot.bean.Account;
import org.springframework.stereotype.Service;

//@Service
public interface AccountService {
    Account getbyid(Long id);
}

