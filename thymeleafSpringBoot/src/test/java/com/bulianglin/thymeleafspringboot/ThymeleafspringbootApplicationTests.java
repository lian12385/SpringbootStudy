package com.bulianglin.thymeleafspringboot;

import com.bulianglin.thymeleafspringboot.bean.User;
import com.bulianglin.thymeleafspringboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ThymeleafspringbootApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Long along = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        log.info("记录总数：{}",along);
        log.info("数据类型：{}",dataSource.getClass());
    }
    @Test
    void testUser(){
        User user = userMapper.selectById(2L);
        log.info("信息为：{}",user);
    }
    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");
        String hell0 = operations.get("hello");
        System.out.println(hell0);
    }

}
