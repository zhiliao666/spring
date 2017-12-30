package com.zhang.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zhang.dto.User;


@RestController
@RequestMapping("/api")
public class TestApi {
	
	/**
	 * 字符串参数
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/testString" , method = RequestMethod.GET)
	public String testString(String name){
		System.out.println("#############################"+name);
		return "你好："+name;
	}
	
	/**
	 * 对象参数
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/testObject" , method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody User testObject(@RequestBody User user){
		System.out.println("#############################"+JSON.toJSONString(user));
		return user;
	}
}
