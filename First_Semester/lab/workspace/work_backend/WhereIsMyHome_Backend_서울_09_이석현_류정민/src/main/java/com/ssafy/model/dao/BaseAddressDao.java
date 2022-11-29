package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.model.dto.BaseAddress;
import com.ssafy.util.DBUtil;

public class BaseAddressDao {

	private DBUtil dbUtil = DBUtil.getInstance();

	// 거래정보 조회
	public BaseAddress getBaseAddress(String dongCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseAddress address = new BaseAddress();
		
		String sql = "select no, sidoName, gugunName, dongName, dongCode, lat, lng "
				+ "from baseaddress "
				+ "where dongCode= ? ";

		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongCode);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			address = new BaseAddress(
						rs.getInt("no"), rs.getString("sidoName"), 
						rs.getString("gugunName"), rs.getString("dongName"),
						rs.getString("dongCode"),rs.getString("lat"), rs.getString("lng"));
			
			return address;
			
		} finally {
			dbUtil.close(rs,pstmt,conn);
		}
		
	}
}
