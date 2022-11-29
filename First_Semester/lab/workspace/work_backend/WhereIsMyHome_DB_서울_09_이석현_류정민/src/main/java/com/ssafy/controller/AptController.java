package com.ssafy.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.BaseAddress;
import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.service.HouseDealService;

public class AptController implements Controller{

	private HouseDealService houseDealService = new HouseDealService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = request.getServletPath();
		
		// 실거거래 정보
		if(url.equals("/apt/list.do")) {
			// 거래정보 조회 페이지로 이동
			return getHouseDealPage(request, response);
		} else if(url.equals("/apt/dong/list.do")) { 
			// 동별 거래정보 조회
			return getHouseDealListByDong(request, response);
		} else if(url.equals("/apt/apt/list.do")) { 
			// 아파트별 거래정보 조회
			return getHouseDealListByApt(request, response);
		} else if(url.equals("/apt/latlng.do")) { 
			// 위도, 경도 가져오기
			return getLatLng(request, response);
		}
		
		return null;
	}

	protected PageInfo getHouseDealPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new PageInfo(true, "/apt/list.jsp");
	}
	
	protected DataInfo getHouseDealListByDong(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongCode = request.getParameter("dongCode");
		
		List<HouseDeal> houseDeals = houseDealService.getHouseDealsByDong(dongCode);
		
		return new DataInfo("application/json", houseDeals);
	}
	
	protected DataInfo getHouseDealListByApt(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String aptName = request.getParameter("aptName");
		
		List<HouseDeal> houseDeals = houseDealService.getHouseDealsByApt(aptName);

		return new DataInfo("application/json", houseDeals);
	}
	
	protected DataInfo getLatLng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String dongCode = request.getParameter("dongCode");
		
		BaseAddress latlng = houseDealService.getLatLng(dongCode);

		return new DataInfo("application/json", latlng);
	}
	
}
