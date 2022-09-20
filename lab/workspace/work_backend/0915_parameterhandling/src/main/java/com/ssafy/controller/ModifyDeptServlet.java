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

@WebServlet("/dept/modify.do")
public class ModifyDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 0. set parameter encoding
		request.setCharacterEncoding("utf-8");
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// 2. call Model(Service)
		int res;
		try {
			res = deptService.updateDept(deptno, dname, loc);
			// 3. move page by result
			if(res != -1) {
				request.setAttribute("msg", "부서 수정에 성공하였습니다.");
			}else {
				request.setAttribute("msg", "부서 수정에 실패하였습니다.");
			}
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
