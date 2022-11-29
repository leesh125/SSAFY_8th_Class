package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Environ;
import com.ssafy.util.DBUtil;

public class EnvironDAO {

	DBUtil dbUtil = DBUtil.getInstance();
	
	// 환경정보 가져오기
	public List<Environ> getEnvironsByDong(String dongCode) throws SQLException{
		
		List<Environ> environs = new ArrayList<Environ>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select envinfo.no, companyName, businessCode, businessName, checkDate, checkInst, checkType, disposal, checkList, address, lat, lng "
				+ "from envinfo, baseaddress "
				+ "where address like concat(\"%\", sidoName, \" \", gugunName, \" \", dongName, \"%\") and dongCode like ? ";
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+dongCode+'%');
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				environs.add(new Environ(
							rs.getInt("no"),
							rs.getString("companyName"),
							rs.getInt("businessCode"),
							rs.getString("businessName"),
							rs.getString("checkDate"),
							rs.getInt("checkInst"),
							rs.getString("checkType"),
							rs.getString("disposal"),
							rs.getString("checkList"),
							rs.getString("address"),
							rs.getString("lat"),
							rs.getString("lng")
						));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return environs;
	}
}
