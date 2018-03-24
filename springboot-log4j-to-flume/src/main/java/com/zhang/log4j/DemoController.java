package com.zhang.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
	
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping(value="test",method = RequestMethod.GET)
	public String test(String name){
		logger.info("info log name ====="+name);
//		logger.debug("debug log name ======"+name);
//		logger.error("error log name ====== "+name);
		return name;
	}
}
