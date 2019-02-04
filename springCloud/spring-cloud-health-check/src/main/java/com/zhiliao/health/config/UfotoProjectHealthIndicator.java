package com.zhiliao.health.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

public class UfotoProjectHealthIndicator implements HealthIndicator {
	
	/**
	 * 自定义服务状态   默认false 也就是默认服务是不可用的状态不接收流量
	 */
	private TomcatHealthCheckProperties tomcatHealthCheckProperties;
	
	
	public UfotoProjectHealthIndicator(TomcatHealthCheckProperties tomcatHealthCheckProperties){
		this.tomcatHealthCheckProperties = tomcatHealthCheckProperties;
	}

	@Override
	public Health health() {
		
		if(tomcatHealthCheckProperties.status){
			return new Health.Builder(Status.UP).build();
		}

		return new Health.Builder(Status.DOWN).build();
	}

}
