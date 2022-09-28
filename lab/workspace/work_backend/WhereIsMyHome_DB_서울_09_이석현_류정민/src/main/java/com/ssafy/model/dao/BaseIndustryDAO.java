package com.ssafy.model.dao;

import java.sql.*;
import java.util.*;

import com.ssafy.model.dto.BaseIndustry;
import com.ssafy.util.DBUtil;

// 업종코드 정보 관련
public class BaseIndustryDAO {
	
	DBUtil dbUtil = DBUtil.getInstance();

	// 대분류코드, 대분류명 조회
	public List<BaseIndustry> getLargeIndusts() throws SQLException{
		
		List<BaseIndustry> industries = new ArrayList<BaseIndustry>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select distinct largeIndustCode, largeIndustName "
					+ "from baseindustry "
					+ "order by largeIndustCode ";
	
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				industries.add(
						new BaseIndustry(rs.getString("largeIndustCode"), rs.getString("largeIndustName")));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return industries;
	}
	
	// 중분류코드, 중분류명 조회
	public List<BaseIndustry> getMediumIndusts(String largeIndustCode) throws SQLException{
		
		List<BaseIndustry> industries = new ArrayList<BaseIndustry>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select distinct mediumIndustCode, mediumIndustName "
					+ "from baseindustry "
					+ "where largeIndustCode= ? "
					+ "order by mediumIndustCode ";
	
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, largeIndustCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				industries.add(
						new BaseIndustry(rs.getString("mediumIndustCode"), rs.getString("mediumIndustName")));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return industries;
	}
	
	// 소분류코드, 소분류명 조회
	public List<BaseIndustry> getSmallIndusts(String mediumIndustCode) throws SQLException{
		
		List<BaseIndustry> industries = new ArrayList<BaseIndustry>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select distinct smallIndustCode, smallIndustName "
					+ "from baseindustry "
					+ "where mediumIndustCode= ? "
					+ "order by smallIndustCode ";
	
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mediumIndustCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				industries.add(
						new BaseIndustry(rs.getString("smallIndustCode"), rs.getString("smallIndustName")));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return industries;
	}
}
