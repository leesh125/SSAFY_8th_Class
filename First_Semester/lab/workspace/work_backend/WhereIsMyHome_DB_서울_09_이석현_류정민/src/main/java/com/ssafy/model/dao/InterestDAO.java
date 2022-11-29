package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DBUtil;

public class InterestDAO {
	
	private DBUtil dbUtil = DBUtil.getInstance();

	public int register(String userId, String dongCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "insert into interestarea(userid,dongcode) values(?,?)";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, dongCode);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public List<String> getInterests(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<>();

		String sql = "select d.dongName from interestarea i join dongcode d using (dongCode) where i.userid = ?";
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}

}
