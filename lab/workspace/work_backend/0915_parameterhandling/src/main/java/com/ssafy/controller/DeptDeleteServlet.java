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
		boolean isDeleted;
		try {
			isDeleted = deptService.deleteDept(deptno);
			if(isDeleted) {
				request.setAttribute("msg", "부서 삭제에 성공하였습니다.");
			}else {
				request.setAttribute("msg", "부서 삭제에 실패하였습니다.");
			}
			request.setAttribute("isDeleted", isDeleted);
			request.getRequestDispatcher("./list.do").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("../error.jsp").forward(request, response);
			return;
		}
		
	}


}
