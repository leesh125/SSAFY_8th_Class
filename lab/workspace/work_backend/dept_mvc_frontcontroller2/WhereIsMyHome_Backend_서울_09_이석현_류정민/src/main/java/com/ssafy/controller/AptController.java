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
		
		// 모든 거래정보 가져오기
		if(url.equals("/apt/list.do")) {
			System.out.println("모든 거래 정보");
			return getHouseDealList(request, response);
		} else if(url.equals("/apt/dong/list.do")) { 
			System.out.println("동별 거래 정보");
			return getHouseDealListByDong(request, response);
		} else if(url.equals("/apt/apt/list.do")) { 
			System.out.println("아파트별 거래 정보");
			return getHouseDealListByApt(request, response);
		} else if(url.equals("/apt/latlng.do")) { 
			System.out.println("위도, 경도 가져오기");
			return getLatLng(request, response);
		}
		
		return null;
	}

	protected PageInfo getHouseDealList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new PageInfo(true, "/apt/apt_info.jsp");
	}
	
	protected DataInfo getHouseDealListByDong(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongCode = request.getParameter("dongCode");
		System.out.println("거래정보 가져와..........."+dongCode);
		
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
	
//	protected DataInfo getSidoCodeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		List<SidoCode> sidoCodes = sidoCodeService.getSidoCodes();
//		
//		return new DataInfo("application/json", sidoCodes);
//	}
}
