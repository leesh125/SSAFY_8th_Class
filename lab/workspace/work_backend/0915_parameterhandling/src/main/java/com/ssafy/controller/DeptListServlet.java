package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

@WebServlet("/dept/list.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptService deptService = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet");
		List<Dept> depts = deptService.getDepts();
		
		request.setAttribute("deptList", depts);
		request.getRequestDispatcher("/dept/list.jsp").forward(request, response);
		return; // 페이지 이동 후 return으로 아래 코드 실행 안되게 실수 방지
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
