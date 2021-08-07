package com.bulianglin.thymeleafspringboot.config;

import com.bulianglin.thymeleafspringboot.intercetor.LoginIntercetor;
import com.bulianglin.thymeleafspringboot.intercetor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc  //全面接管webmvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/aa/**")
//                .addResourceLocations("classpath:/static/");
//    }
//    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginIntercetor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**","/fonts/**", "/images/**","/js/**",
                        "/aa/**");
        //registry.addInterceptor(redisUrlCountInterceptor)
        //        .addPathPatterns("/**")
        //        .excludePathPatterns("/", "/login", "/css/**","/fonts/**", "/images/**","/js/**",
        //                "/aa/**");
        //        //.excludePathPatterns("/", "/login", "/css/**","/fonts/**", "/images/**","/js/**",
        //        //        "/aa/**","/sql","/acc");
    }

}
