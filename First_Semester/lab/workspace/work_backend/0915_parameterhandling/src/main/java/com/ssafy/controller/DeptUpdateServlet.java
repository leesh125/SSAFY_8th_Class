package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.service.DeptService;

/**
 * Servlet implementation class DeptUpdateServlet
 */
//@WebServlet("/dept/modify.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. request parameter encoding
		request.setCharacterEncoding("utf-8");
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call service
		try {
			int updateDept = deptService.updateDept(deptno,request.getParameter("dname"),request.getParameter("loc"));
			request.getRequestDispatcher("./list.do").forward(request, response);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
