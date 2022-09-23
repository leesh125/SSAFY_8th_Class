package com.ssafy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.PageInfo;

public class AptController implements Controller{

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		// housedeal/list.do
		
		// /dong/list.do
		// /apt/list.do
		
		
		
		// 모든 거래정보 가져오기
		if(url.equals("/housedeal/list.do")) {
			return getHouseDealList(request, response);
		}
		
		if(url.equals("/apt/apt_info.jsp")) {
			return getHouseDeal(request, response);
		}
		
		// 아파트별 거래정보 가져오기
		else if(url.equals("/apt/detail_info.do")) {
			return getHouseDealBy
		}
		
		
		
		return null;
	}

	protected PageInfo getHouseDealList(HttpServletRequest request, HttpServletResponse response) {
		return new PageInfo(true,"/housedeal/list.jsp");
	}
}
