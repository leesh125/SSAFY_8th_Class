package com.ssafy.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;

public class DeptController implements Controller {

	
	private DeptService deptService = new DeptService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		if(url.equals("/dept/list.do")) {
			return getDeptList(request, response);
		}else if(url.equals("/dept/detail.do")) {
			return getDeptDetail(request, response);
		}else if(url.equals("/dept/delete.do")) {
			return deptDelete(request, response);
		}else if(url.equals("/dept/modify.do")) {
			return deptModify(request, response);
		}else if(url.equals("/dept/register.do")) {
			return deptRegister(request, response);
		}else if(url.equals("/dept/rest/list.do")) {
			return deptRegister(request, response);
		}
		return null;
	}
	
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Dept> depts = deptService.getDepts();
		request.setAttribute("deptList", depts);
		return new PageInfo(true, "/dept/list.jsp");
	}
	
	protected DataInfo getDeptRestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Dept> depts = deptService.getDepts();
		request.setAttribute("deptList", depts);
		return new DataInfo("application/json",depts);
	}
	
	protected PageInfo getDeptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call service
		Dept dept = deptService.getDept(deptno);
		
		request.setAttribute("dept", dept);
		return new PageInfo(true, "./detail_form.jsp");

	}
	
	protected PageInfo deptDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		// 2. call service
		boolean isDeleted;
		
		isDeleted = deptService.deleteDept(deptno);
		if(isDeleted) {
			request.setAttribute("msg", "부서 삭제에 성공하였습니다.");
		}else {
			request.setAttribute("msg", "부서 삭제에 실패하였습니다.");
		}
		request.setAttribute("isDeleted", isDeleted);
		return new PageInfo(true, "./list.do");
		
	}

	protected PageInfo deptModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 1. get parameter
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// 2. call Model(Service)
		int res;

		res = deptService.updateDept(deptno, dname, loc);
		// 3. move page by result
		if(res != -1) {
			request.setAttribute("msg", "부서 수정에 성공하였습니다.");
		}else {
			request.setAttribute("msg", "부서 수정에 실패하였습니다.");
		}

		return new PageInfo(true, "./list.do");
	}
	
	protected PageInfo deptRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
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
			return new PageInfo(false, "./list.do");
		}else {
			request.setAttribute("errorMsg", "등록에 실패하였습니다.");
			return new PageInfo(true, "./register_form.jsp");
		}
	}
}
