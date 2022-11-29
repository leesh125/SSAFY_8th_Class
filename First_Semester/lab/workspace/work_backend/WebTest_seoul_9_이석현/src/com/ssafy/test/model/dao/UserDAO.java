package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.util.DBUtil;

public class UserDAO {

	private DBUtil dbUtil = DBUtil.getInstance();
	
	public boolean login(String userId, String password) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from user where id = ? and pw = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return false;
	}
	
}
