package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.BaseIndustry;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.service.IndustryService;

public class IndustryController implements Controller {

	IndustryService industryService = new IndustryService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		// 분류코드, 분류명 가져오기
		if(url.equals("/indust/code.do")) {
			return getIndust(request, response);
		}
		
		return null;
	}
	
	protected DataInfo getIndust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String industCode = request.getParameter("industCode");
		System.out.println("업종코드 "+industCode+" "+industCode.length());
		
		List<BaseIndustry> industries = null;
		
		int len = industCode.length();
		
		switch(len) {
		
		case 0:
			// 대분류코드 조회
			industries = industryService.getLargeIndusts();
			break;
		case 1:
			// 대분류코드에 맞는 중분류코드 조회
			industries = industryService.getMeidumIndusts(industCode);
			break;
		case 3:
			// 중분류코드에 맞는 소분류코드 조회
			industries = industryService.getSmallIndusts(industCode);
			break;
		}
		
		System.out.println(industries);
		return new DataInfo("application/json", industries);
	}
}
