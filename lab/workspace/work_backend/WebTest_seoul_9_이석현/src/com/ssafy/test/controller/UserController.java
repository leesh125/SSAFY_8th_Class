package com.ssafy.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.test.dto.PageInfo;
import com.ssafy.test.model.service.UserService;

public class UserController implements Controller {

	private UserService userService = new UserService();
	
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception  {
		
		String url = request.getServletPath();
		
		if(url.equals("/user/login.do")) {
			return login(request, response);
		}else if(url.equals("/user/logout.do")) {
			return logout(request, response);
		}else if(url.equals("/user/loginForm.do")) {
			return loginForm(request, response);
		}
		return null;
	}
	
	protected PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. get parameter
		String userId = request.getParameter("id");
		String password = request.getParameter("pw");
		String checkBox = request.getParameter("remember");

		
		
		boolean isLogined = userService.login(userId, password);
		
		if(isLogined) {
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", userId);
			Cookie cookie = new Cookie("savedId", userId);
			Cookie cookie2 = new Cookie("userInfo", userId);
			if(checkBox != null) {
				response.addCookie(cookie);
			}else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			response.addCookie(cookie2);
			return new PageInfo(false,"/index.do");
		}else {
			request.setAttribute("errorMsg","아이디가 다릅니다.");
			return new PageInfo(true,"/user/login.jsp");
		}
		

	}
	
	protected PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return new PageInfo(false,"/index.do");

	}
	
	protected PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(false,"/user/login.jsp");
	}

}
