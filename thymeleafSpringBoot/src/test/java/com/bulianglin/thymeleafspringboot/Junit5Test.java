package com.bulianglin.thymeleafspringboot;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit5功能测试类")
public class Junit5Test {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testassumptions(){
        Assumptions.assumeTrue(false, "结果不是true");
        System.out.println("111111");
    }

    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(3,2);
        assertEquals(6, cal, "业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1, obj2, "两个对象不一样");
    }

    int cal(int i, int j){
        return i+j;
    }

    @Test
    @DisplayName("array assertion")
    void array(){
        assertArrayEquals(new int[]{1,2}, new int[]{2,1},"数组内容不相等");
    }

   @Test
   @DisplayName("组合断言")
   void all(){
        assertAll("test",
                ()->assertTrue(true && true,"结果不为true"),
                ()->assertEquals(1,1,"结果不是1"));
       System.out.println("=====");
   }


   @DisplayName("异常断言")
   @Test
    void testException(){
        assertThrows(ArithmeticException.class,()->{
            int i = 10/0;
        },"业务逻辑居然正常运行？");
   }

   @DisplayName("快速失败")
    @Test
    void testFail(){
        if(1==2){
            fail("测试失败");
        }
   }

   @DisplayName("测试displayname注解")
    @Test
    void testDisplayName(){
       System.out.println("1");
       System.out.println(jdbcTemplate);
   }

   @Disabled
    @Test
    void test2(){
       System.out.println(2);
   }

   @RepeatedTest(5)
    @Test
    void test3(){
       System.out.println(5);
   }

   @Timeout(value = 500 ,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException{
        Thread.sleep(600);
   }
   @BeforeEach
    void testBeforeEach(){
       System.out.println("测试就要开始了...");
   }
   @AfterEach
    void testAfterEach(){
       System.out.println("测试结束了....");
   }

   @BeforeAll
    static void testBeforeAll(){
       System.out.println("所有测试就要开始了...");
   }

   @AfterAll
    static void testAfterAll(){
       System.out.println("所有测试都已经结束了。。");
   }


}
