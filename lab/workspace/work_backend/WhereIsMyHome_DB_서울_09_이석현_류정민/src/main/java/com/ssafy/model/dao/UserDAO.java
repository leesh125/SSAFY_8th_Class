package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.ssafy.model.dto.User;
import com.ssafy.util.DBUtil;

public class UserDAO {

	private DBUtil dbUtil = DBUtil.getInstance();
	
	public String login(String userId, String password) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select username from userinfo where userid = ? and password = ?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return null;
	}

	public int register(String userId, String password, String username, String address, String phoneNumber) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "insert into userinfo values(?,?,?,?,?)";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
			pstmt.setString(4, address);
			pstmt.setString(5, phoneNumber);
			
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public User getUser(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select userid,password,username,address from userinfo where userid = ?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),"");
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return null;
	}

	public int update(String userId, String password, String username, String address) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "update userinfo set password=?, username=?, address=? where userid=?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.setString(3, address);
			pstmt.setString(4, userId);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public int delete(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "delete from userinfo where userid=?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
