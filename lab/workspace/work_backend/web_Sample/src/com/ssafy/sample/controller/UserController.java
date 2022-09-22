package com.ssafy.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.sample.model.dto.PageInfo;
import com.ssafy.sample.model.service.UserService;


public class UserController implements Controller {
	
	private UserService userService = new UserService();
	
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
		String url = request.getServletPath();
		
		if(url.equals("/user/login.do")) {
			return login(request, response);
		}else if(url.equals("/user/logout.do")) {
			return logout(request, response);
		}else if(url.equals("/user/login_form.do")) {
			return loginForm(request, response);
		}
		return null;
	}
	
	protected PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. get parameter
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

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
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userName", name);
			
			
			return new PageInfo(false,"/index.do");
		}else {
			request.setAttribute("errorMsg","아이디가 다릅니다.");
			return new PageInfo(true,"/user/login.jsp");
		}
		

	}
	
	protected PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
		HttpSession session = request.getSession();
		session.invalidate();
		return new PageInfo(false,"/index.jsp");

	}
	
	protected PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(false,"/user/login.jsp");
	}
}