package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.DeptService;

// loadOnStartup = 서블릿 호출 없어도 서블릿이 먼저 실행된다(우선순위 기준)
@WebServlet(loadOnStartup = 1, urlPatterns= {"*.do","*.ssafy"})
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static DeptService deptService = new DeptService();
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		application.setAttribute("root", application.getContextPath());
		System.out.println("root set...");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 공통 전처리
		
		// 요청에 따라 sub controller로 분기
		String url = request.getServletPath();
		System.out.println("url: " + url);
		
		
		PageInfo pageInfo = null;
		try {
			if(url.equals("/dept/list.do")) {
				pageInfo = getDeptList(request, response);
			}else if(url.equals("/dept/detail.do")) {
				pageInfo = getDeptDetail(request, response);
			}else if(url.equals("/dept/delete.do")) {
				pageInfo = deptDelete(request, response);
			}else if(url.equals("/dept/modify.do")) {
				pageInfo = deptModify(request, response);
			}else if(url.equals("/dept/register.do")) {
				pageInfo = deptRegister(request, response);
			}
				
			if(pageInfo.isForward()) {
				request.getRequestDispatcher(pageInfo.getPage()).forward(request, response);
				return;
			}else {
				response.sendRedirect(request.getContextPath() + pageInfo.getPage());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			request.getRequestDispatcher("../error.jsp").forward(request, response);
			return;
		}
		// 공통 후처리
	}
	
	
	protected PageInfo getDeptList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Dept> depts = deptService.getDepts();
		request.setAttribute("deptList", depts);
		return new PageInfo(true, "/dept/list.jsp");
		
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
