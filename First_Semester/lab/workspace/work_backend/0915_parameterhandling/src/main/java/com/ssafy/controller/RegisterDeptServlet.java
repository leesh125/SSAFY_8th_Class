package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/register.do")
public class RegisterDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService deptService = new DeptService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. request parameter encoding
		request.setCharacterEncoding("utf-8");
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// 2. verify parameter
		
		// 3. call service
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		
		// 4. view page by result
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(res) {
			response.sendRedirect("./list.do");
			return;
		} else {
			request.setAttribute("errorMsg", "등록에 실패하였습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("./register_form.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
