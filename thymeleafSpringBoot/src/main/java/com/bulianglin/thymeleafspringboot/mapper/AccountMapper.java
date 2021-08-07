package com.bulianglin.thymeleafspringboot.mapper;

import com.bulianglin.thymeleafspringboot.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    public Account getAcc(Long id);
}
