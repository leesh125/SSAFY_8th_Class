package com.ssafy.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.User;
import com.ssafy.model.service.UserService;

public class UserController implements Controller{

	private UserService userService = new UserService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/user/register.do")) {
			return register(request, response);
		}else if(url.equals("/user/login.do")) {
			return login(request, response);
		}else if(url.equals("/user/logout.do")) {
			return logout(request, response);
		}else if(url.equals("/user/memberInfo.do")) {
			return memberInfo(request, response);
		}else if(url.equals("/user/modify.do")) {
			return modify(request, response);
		}else if(url.equals("/user/delete.do")) {
			return delete(request, response);
		}
		
		
		return null;
	}

	private DataInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("login_id");
		String password = request.getParameter("login_password");

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
			session.setAttribute("username", name);
			
			System.out.println("이름은 " + name);
			return new DataInfo("application/json",name);
		}else {
			request.setAttribute("errorMsg","아이디가 다릅니다.");
			return new DataInfo("application/json",null);
		}
	}

	private DataInfo register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		
		boolean isRegistered = userService.register(userId, password,username,address,"");		
		request.setAttribute("isRegistered", isRegistered);
		
		
		return new DataInfo("application/json", isRegistered);
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
	
	private PageInfo memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = (String) request.getParameter("userId");
		System.out.println("userId :  " + userId);
		User user = userService.getUser(userId);
		
		request.setAttribute("user", user);
		return new PageInfo(true,"/user/memberInfo.jsp");
	}
	
	private DataInfo modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String address = request.getParameter("address");
		
		boolean isUpdated = userService.update(userId, password,username,address);		
		request.setAttribute("isUpdated", isUpdated);
		
		
		return new DataInfo("application/json", isUpdated);
	}
	
	private DataInfo delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");

		boolean isDeleted = userService.delete(userId);		
		request.setAttribute("isDeleted", isDeleted);
		
		
		return new DataInfo("application/json", isDeleted);
	}

}
