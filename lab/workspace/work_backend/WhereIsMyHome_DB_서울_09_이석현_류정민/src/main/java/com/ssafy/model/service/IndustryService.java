package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.BaseIndustryDAO;
import com.ssafy.model.dto.BaseIndustry;

public class IndustryService {

	BaseIndustryDAO industryDao = new BaseIndustryDAO();
	
	// 대분류코드, 대분류명 조회
	public List<BaseIndustry> getLargeIndusts() throws SQLException{
		return industryDao.getLargeIndusts();
	}
	
	// 대분류코드, 대분류명 조회
	public List<BaseIndustry> getMeidumIndusts(String largeIndustCode) throws SQLException{
		return industryDao.getMediumIndusts(largeIndustCode);
	}
	
	// 대분류코드, 대분류명 조회
	public List<BaseIndustry> getSmallIndusts(String mediumIndustCode) throws SQLException{
		return industryDao.getSmallIndusts(mediumIndustCode);
	}
}
