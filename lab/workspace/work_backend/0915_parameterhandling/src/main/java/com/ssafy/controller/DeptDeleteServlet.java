package com.ssafy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/delete.do")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private DeptService deptService = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. request parameter encoding
		request.setCharacterEncoding("utf-8");
		
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call service
		boolean isDeleted = deptService.deleteDept(deptno);
		
		request.setAttribute("isDeleted", isDeleted);
		request.getRequestDispatcher("./list.do").forward(request, response);
		return;
	}


}
