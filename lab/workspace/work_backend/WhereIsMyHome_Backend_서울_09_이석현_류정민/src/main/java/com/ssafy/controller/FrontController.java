package com.ssafy.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.PageInfo;

// loadOnStartup = 서블릿 호출 없어도 서블릿이 먼저 실행된다(우선순위 기준)
@WebServlet(loadOnStartup = 1, urlPatterns= {"*.do","*.ssafy"})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserController userController = new UserController();
	private AptController aptController = new AptController();
	private HomeController homeController = new HomeController();
	private NoticeController noticeController = new NoticeController();
	
	private String root;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = getServletContext();
		root = application.getContextPath();
		application.setAttribute("root", root);
		System.out.println("root set... : "+root);
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
		
		if(url.startsWith("/apt") || url.startsWith("/area")) {
			// 로그인 상태 판단
			HttpSession session = request.getSession();
			if(session.getAttribute("userId") == null) {
				System.out.println("로그인 안됨");
				response.sendRedirect(request.getContextPath()+"/user/login.do");
			}
			return;
		}
		
		Object result = null;
		try {
			Controller controller = null;
			if(url.startsWith("/user")) {
				controller = userController;
			}else if(url.startsWith("/apt")) {
				controller = aptController;
			}else if(url.startsWith("/area")) {
				// controller = areaController;
			}else if(url.startsWith("/notice")) {
				controller = noticeController;
			}else {
				controller = homeController;
			}
			
			if(controller != null) {
				result = controller.handleRequest(request, response);
			}
			
			if(result instanceof PageInfo) {
				PageInfo pageInfo = (PageInfo) result;
				if(pageInfo.isForward()) {
					request.getRequestDispatcher(pageInfo.getPage()).forward(request, response);
					return;
				}else {
					
					response.sendRedirect(root + pageInfo.getPage());
				}
			}else if(result instanceof DataInfo) {
				DataInfo dataInfo = (DataInfo) result;
				response.setContentType(dataInfo.getContentType());
				if(dataInfo.getContentType().equals("application/json")) {
					ObjectMapper mapper = new ObjectMapper();
					String value = mapper.writeValueAsString(dataInfo.getData());
					
					response.getWriter().println(value);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if(result instanceof PageInfo) {
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			return;
		}
		// 공통 후처리
	}
	
	
}

