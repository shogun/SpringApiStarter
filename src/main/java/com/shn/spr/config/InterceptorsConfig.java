package com.shn.spr.config;

import com.shn.spr.utils.interceptor.ApiVersionHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class InterceptorsConfig  extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //todo inject version here
        registry.addInterceptor(new ApiVersionHeaderInterceptor("1.1.3"));
    }
}
