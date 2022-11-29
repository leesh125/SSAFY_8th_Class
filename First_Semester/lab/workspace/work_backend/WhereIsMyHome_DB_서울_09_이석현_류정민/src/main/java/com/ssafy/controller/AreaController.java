package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.model.dto.DataInfo;
import com.ssafy.model.dto.Environ;
import com.ssafy.model.dto.HouseDeal;
import com.ssafy.model.dto.PageInfo;
import com.ssafy.model.dto.Store;
import com.ssafy.model.service.EnvironService;
import com.ssafy.model.service.StoreService;

public class AreaController implements Controller {
	
	EnvironService environService = new EnvironService();
	StoreService storeService = new StoreService();

	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		// 환경정보 가져오기
		if(url.equals("/area/environ.do")) {
			// 환경정보 조회 페이지로 이동
			return getEnvironPage(request, response);
		} else if(url.equals("/area/environ/list.do")) { 
			// 동별 환경정보 조회
			return getEnvironListByDong(request, response);
		} else if(url.equals("/area/store.do")) { 
			// 관심지역 둘러보기 페이지로 이동
			return getStorePage(request, response);
		} else if(url.equals("/area/store/list.do")) { 
			// 관심지역 상권정보 조회
			return getStoreListByIndust(request, response);
		}
		
		return null;
	}
	
	protected PageInfo getEnvironPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return new PageInfo(false, "/area/environ.jsp");
	}
	
	protected DataInfo getEnvironListByDong(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String dongCode = request.getParameter("dongCode");
		
		List<Environ> environs = environService.getEnvironsByDong(dongCode);
		
		return new DataInfo("application/json", environs);
	}
	
	protected PageInfo getStorePage(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new PageInfo(true, "/area/store.jsp");
	}
	
	protected DataInfo getStoreListByIndust(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String industCode = request.getParameter("industCode");
		
		List<Store> stores = storeService.getStoresByIndust(industCode);
		
		return new DataInfo("application/json", stores);
	}
}
