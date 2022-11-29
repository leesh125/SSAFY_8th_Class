package com.ssafy.empapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	@RequestMapping({"/index.do", "/"})
	protected String index() throws Exception {	
		return "index";
	}
}
