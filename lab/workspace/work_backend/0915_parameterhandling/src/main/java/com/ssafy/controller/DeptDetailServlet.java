package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;


@WebServlet("/dept/detail.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call service
		try {
			Dept dept = deptService.getDept(deptno);
			
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("./detail_form.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("../error.jsp").forward(request, response);
			return;
		}
	}

}
