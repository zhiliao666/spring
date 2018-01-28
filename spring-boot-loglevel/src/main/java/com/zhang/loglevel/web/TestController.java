package com.zhang.loglevel.web;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
	
	private static Logger logger = Logger.getLogger(TestController.class);
	
	@RequestMapping(value="/get" , method = RequestMethod.GET)
	public String testString(){
		logger.debug("执行debug日志111111。。。。。。。。");
		logger.error("执行Error日志111111。。。。。。。。");
		logger.info("执行info日志111111。。。。。。。。");
		return "true";
	}
}
