package com.ssafy.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.InterestArea;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.InterestService;

public class InterestAreaController implements Controller {
	
	InterestService interestService = new InterestService();

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/interest/regist.do")) {
			return registArea(request, response);
		}else if(url.equals("/interest/regist2.do")) {
			return registTest(request, response);
		}
		return null;
	}
	
	private PageInfo registTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		List<String> interests = interestService.getInterests(userId);

		request.setAttribute("interests", interests);
		return new PageInfo(true, "/area/regist2.jsp");
	}

	private DataInfo registArea(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		String dongCode = request.getParameter("dongCode");
		
		boolean isRegistered = interestService.register(userId,dongCode);
		List<String> interests = interestService.getInterests(userId);

		request.setAttribute("interests", interests);
		request.setAttribute("isRegistered", isRegistered);
		
		return new DataInfo("application/json", isRegistered);
	}

}
