package com.ssafy.empapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.empapp.model.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
//	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception  {
//		
//		String url = request.getServletPath();
//		
//		if(url.equals("/user/login.do")) {
//			return login(request, response);
//		}else if(url.equals("/user/logout.do")) {
//			return logout(request, response);
//		}else if(url.equals("/user/logout.do")) {
//			return logout(request, response);
//		}
//		return null;
//	}
	
	@PostMapping("/login.do")
	protected String login(String userId, String password, HttpSession session, Model model) throws Exception {
		
		String name = userService.login(userId, password);
		
		if(name != null) {
//			Cookie idCookie = new Cookie("userId", userId);
//			Cookie nameCookie = new Cookie("userName", URLEncoder.encode(name,"utf-8"));
//			
//			idCookie.setPath(request.getContextPath());
//			nameCookie.setPath(request.getContextPath());
//			
//
//			response.addCookie(idCookie);
//			response.addCookie(nameCookie);
			
			session.setAttribute("userId", userId);
			session.setAttribute("userName", name);
			
			return "redirect:/index.do";
		}else {
			model.addAttribute("errorMsg","아이디나 비밀번호가 일치하지 않습니다.");
			return "user/login";
		}
		

	}
	
	@GetMapping("/logout.do")
	protected String logout(HttpSession session) throws Exception {
		
		// 1. get parameter
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null && cookies.length>0) {
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals("userId") || cookie.getName().equals("userName")) {
//					cookie.setPath(request.getContextPath());
//					cookie.setMaxAge(0);
//					response.addCookie(cookie);
//				}
//			}
//		}
		session.invalidate();
		return "redirect:/index.do";
	}
	
	@GetMapping("/login_form.do")
	protected String loginForm() {
		return "user/login";
	}
}
