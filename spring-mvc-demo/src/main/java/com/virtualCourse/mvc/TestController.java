package com.virtualCourse.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/test")
public class TestController {
	@RequestMapping(method=RequestMethod.GET, value="/index")
	public String showAdminBack(Model model, HttpServletRequest req, HttpServletResponse resp){
		System.out.println("测试通过");
		return "pages/index";
	}

}
