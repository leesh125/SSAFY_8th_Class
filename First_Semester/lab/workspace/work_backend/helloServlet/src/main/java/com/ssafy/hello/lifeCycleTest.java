package com.ssafy.hello;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifeCycleTest")
public class lifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	public lifeCycleTest() {
		super();
		System.out.println("객체 생성");
	}
	
	@Override
	public void destroy() {
		System.out.println("객체 제거");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("객체 초기화");
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 서비스");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 응답 서비스");
	}

}
