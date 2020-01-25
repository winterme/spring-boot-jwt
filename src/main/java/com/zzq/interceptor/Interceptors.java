package com.zzq.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptors implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，static 目录下的不拦截
        registry.addInterceptor(new ValidateLoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**").excludePathPatterns("/login");
    }
}
