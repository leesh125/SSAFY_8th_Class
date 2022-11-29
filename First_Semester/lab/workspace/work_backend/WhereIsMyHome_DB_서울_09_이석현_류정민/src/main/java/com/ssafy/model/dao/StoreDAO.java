package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Store;
import com.ssafy.util.DBUtil;

public class StoreDAO {
	
	DBUtil dbUtil = DBUtil.getInstance();

	// 소분류코드로 상권 정보 조회하기
	public List<Store> getStoresByIndust(String industCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Store> list = new ArrayList<>();
		
		// 소분류코드로 조회
		String sql = "select * "
				+ "from storeinfo "
				+ "where smallIndustCode = ? and dongCode=1132010800 "
				+ "limit 10 ";

		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, industCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Store(
						rs.getInt("storeCode"), rs.getString("storeName"), rs.getString("placeName"), 
						rs.getString("smallIndustCode"), rs.getString("standardCode"), rs.getString("standardName"),
						rs.getString("dongCode"), rs.getString("address"),
						rs.getInt("postCode"),
						rs.getString("lat"), rs.getString("lng")));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}
}
