package com.zhiliao.health.config;

import org.springframework.boot.actuate.health.Status;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;

public class UfotoHealthHealthCheckHandler implements HealthCheckHandler {

	private UfotoProjectHealthIndicator ufotoProjectHealthIndicator;
	
	public UfotoHealthHealthCheckHandler(UfotoProjectHealthIndicator ufotoProjectHealthIndicator){
		this.ufotoProjectHealthIndicator = ufotoProjectHealthIndicator;
	}
	
	@Override
	public InstanceInfo.InstanceStatus getStatus(
			InstanceInfo.InstanceStatus currentStatus) {

		Status status = ufotoProjectHealthIndicator.health().getStatus();

		if (status == Status.UP) {

			return InstanceInfo.InstanceStatus.UP;

		} else {

			return InstanceInfo.InstanceStatus.DOWN;

		}

	}
}
