package com.zhiliao.health.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhiliao.health.sbin.HealthEndPoint;

/**
 *
 * @author zhangqh
 * @date 2019年1月24日
 */
@Configuration
@EnableConfigurationProperties(TomcatHealthCheckProperties.class)
public class UfotoHealthAutoConfiguration {
	
	@Autowired
	private  TomcatHealthCheckProperties tomcatHealthCheckProperties;
	
	@Bean
	public UfotoProjectHealthIndicator ufotoProjectHealthIndicator(){
		return new UfotoProjectHealthIndicator(tomcatHealthCheckProperties);
	}
	
	@Bean
	public UfotoHealthHealthCheckHandler UfotoHealthHealthCheckHandler(){
		return new UfotoHealthHealthCheckHandler(ufotoProjectHealthIndicator());
	}
	
	/**
	 * 自定义端点控制应用上线下线
	 * @return
	 */
	@Bean
	public HealthEndPoint healthEndPoint(){
		return new HealthEndPoint();
	}
}
