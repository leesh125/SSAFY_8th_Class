package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.HouseDeal;
import com.ssafy.util.DBUtil;

public class HouseDealDAO {
	
	private DBUtil dbUtil = DBUtil.getInstance();

	// 거래정보 조회
	public List<HouseDeal> getHouseDeals() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HouseDeal> list = new ArrayList<>();
		
		String sql = "select hd.no, aptName,dealAmount,area,dealYear,dealMonth,dealDay,lat,lng "
				+ "from housedeal hd, houseinfo hi "
				+ "where hd.aptCode = hi.aptCode "
				+ "limit 100 ";
		
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new HouseDeal(
						rs.getInt("no"), rs.getString("aptName"), 
						rs.getString("dealAmount"), rs.getString("area"),
						rs.getInt("dealYear"),rs.getInt("dealMonth"), rs.getInt("dealDay"),
						rs.getString("lat"), rs.getString("lng")));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}
	
	// 거래 정보 (동별 검색)
	public List<HouseDeal> getHouseDealsByDong(String dongCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HouseDeal> list = new ArrayList<>();
		
		// 동코드로 조회
		String sql = "select hd.no, aptName,dealAmount,area,dealYear,dealMonth,dealDay,lat,lng "
				+ "from housedeal hd, houseinfo hi "
				+ "where hd.aptCode = hi.aptCode and dongCode= ? ";

		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new HouseDeal(
						rs.getInt("no"), rs.getString("aptName"), 
						rs.getString("dealAmount"), rs.getString("area"),
						rs.getInt("dealYear"),rs.getInt("dealMonth"), rs.getInt("dealDay"),
						rs.getString("lat"), rs.getString("lng")));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}
	
	// 거래 정보 (아파트별 검색) - 최대 100개
	public List<HouseDeal> getHouseDealsByApt(String aptName) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<HouseDeal> list = new ArrayList<>();
		
		// 아파트명으로 조회
		String sql = "select hd.no, aptName,dealAmount,area,dealYear,dealMonth,dealDay,lat,lng "
				+ "from housedeal hd, houseinfo hi "
				+ "where hd.aptCode = hi.aptCode and aptName like ? "
				+ "limit 100 ";

		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+aptName+'%');
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new HouseDeal(
						rs.getInt("no"), rs.getString("aptName"), 
						rs.getString("dealAmount"), rs.getString("area"),
						rs.getInt("dealYear"),rs.getInt("dealMonth"), rs.getInt("dealDay"),
						rs.getString("lat"), rs.getString("lng")));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}
	
//	public List<HouseDeal> getHouseDealsByApt(String aptCode) throws SQLException {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ArrayList<HouseDeal> list = new ArrayList<>();
//
//		String sql = "select aptName,dealAmount,area,dealYear,dealMonth,dealDay "
//				+ "from housedeal hd left join houseinfo hi " + "on hd.aptCode = hi.aptCode "
//				+ "where hd.aptCode = ? ";
//		try {
//			conn = dbUtil.getConnection();
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, aptCode);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				list.add(new HouseDeal(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
//						rs.getInt(6)));
//			}
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		return list;
//	}
}
