package com.ssafy.empapp.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor{
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		if(userId == null) {
			System.out.println("로그인 안 된 상태!");
			response.sendRedirect(request.getContextPath() + "/user/login_form.do");
			return false; // 더 이상 chaining을 타지 말고 끊어라
		}
		return true;
	}
}
