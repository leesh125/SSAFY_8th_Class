package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Notice;
import com.ssafy.util.DBUtil;

public class NoticeDAO {

	private DBUtil dbUtil = DBUtil.getInstance();
	
	public List<Notice> getNotices() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Notice> list = new ArrayList<>();
		
		String sql = "select noticeid,title,content,date_time,hit from notice";
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5)));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}

	public Notice getNotice(String noticeId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select noticeid,title,content,date_time,hit from notice where noticeid = ?";
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return new Notice(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return null;
	}

	public int updateNotice(String noticeId, String title, String content) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "update notice set title=?, content=? where noticeid=?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, noticeId);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public int deleteNotice(String noticeId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "delete from notice where noticeid=?";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeId);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

	public int registerNotice(String title, String content) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "insert into notice(title,content,hit) values(?,?,?)";
//		String sql = "select name from userinfo where name like concat('%',?,'%')";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, 0);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
