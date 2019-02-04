package com.zhiliao.health.sbin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import com.zhiliao.health.config.TomcatHealthCheckProperties;

@Endpoint(id = "ufotosbin")
public class HealthEndPoint {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthEndPoint.class);
	
	@Autowired
	private TomcatHealthCheckProperties tomcatHealthCheckProperties;

	
	public final static String OPERATION_ON_LINE = "online";
	
	public final static String OPERATION_OFF_LINE = "offline";

	
	/**
	 * @WriteOperation 对应 http  post类型
	 * @ReadOperation 对应 http  get类型
	 * @param name
	 * @return
	 */
	@WriteOperation
	public String wRtart(@Selector String c) {

		if (OPERATION_ON_LINE.equals(c)) {
			tomcatHealthCheckProperties.status = true;
		} else if (OPERATION_OFF_LINE.equals(c)) {
			tomcatHealthCheckProperties.status = false;
		}else{
			logger.info("command is not found !!!");
			return "command is not found !!!";
		}
		
		return "true";
		
		
	}
	
}
