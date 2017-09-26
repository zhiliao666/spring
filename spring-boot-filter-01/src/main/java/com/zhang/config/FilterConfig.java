package com.zhang.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.DispatcherType;

/**
 * Filter配置
 *
 * @author zhangqh
 * @date 2017年9月23日
 */
@Configuration
public class FilterConfig {
	
    /**
     * 去除参数头尾空格过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean parmsFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new ParamsFilter());
        registration.addUrlPatterns("/*");
        registration.setName("paramsFilter");
        registration.setOrder(Integer.MAX_VALUE-1);
        return registration;
    }
}
