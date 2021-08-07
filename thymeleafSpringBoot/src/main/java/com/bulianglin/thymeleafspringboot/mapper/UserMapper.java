package com.bulianglin.thymeleafspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bulianglin.thymeleafspringboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
