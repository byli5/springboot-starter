package com.imooc.config;

import com.imooc.controller.interceptor.OneInterceptor;
import com.imooc.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description:
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /**
         * 拦截器按照顺序执行
         */
//        registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
//                .addPathPatterns("/one/**");
        registry.addInterceptor(new OneInterceptor()).addPathPatterns("/One/**");

        super.addInterceptors(registry);
    }

}
