package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.NoticeService;

public class NoticeController implements Controller{

	private NoticeService noticeService = new NoticeService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/notice/notice.do")) {
			return getNotices(request, response);
		}else if(url.equals("/notice/noticeDetail.do")) {
			return detail(request, response);
		}
		
		return null;
	}

	private PageInfo detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("노티스 호출!");
		String noticeId = request.getParameter("noticeid");
		Notice notice = noticeService.getNotice(noticeId);
		request.setAttribute("notice", notice);
		
		return new PageInfo(true, "/notice/noticeDetail.jsp");
	}

	private PageInfo getNotices(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Notice> notices = noticeService.getNotices();
		request.setAttribute("notices", notices);
		return new PageInfo(true, "/notice/notice.jsp");
	}

}
