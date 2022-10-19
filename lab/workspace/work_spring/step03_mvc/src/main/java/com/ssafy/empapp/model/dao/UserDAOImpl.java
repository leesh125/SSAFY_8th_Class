package com.ssafy.empapp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.ssafy.empapp.util.DBUtil;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public String login(String userId, String password) throws SQLException {
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select name from userinfo where userid = ? and password = ?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return null;
	}
}
