package com.zhang.loglevel.web2;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test2")
public class TestController2 {
	
	private static Logger logger = Logger.getLogger(TestController2.class);
	
	@RequestMapping(value="/get2" , method = RequestMethod.GET)
	public String testString(){
		logger.debug("执行debug日志222222。。。。。。。。");
		logger.error("执行Error日志222222。。。。。。。。");
		logger.info("执行info日志222222。。。。。。。。");
		return "true";
	}
}
