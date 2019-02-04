package com.zhiliao.health.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ufoto.tomcat.health", ignoreUnknownFields = true)
public class TomcatHealthCheckProperties {

	public boolean status = false;

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	

}
