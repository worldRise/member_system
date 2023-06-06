package com.auther.fan.member_system.config;

import com.auther.fan.member_system.sys.interceptor.AllRequestInterceptor;
import com.auther.fan.member_system.sys.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/login");
//        registry.addInterceptor(new AllRequestInterceptor())
//                .addPathPatterns("/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
