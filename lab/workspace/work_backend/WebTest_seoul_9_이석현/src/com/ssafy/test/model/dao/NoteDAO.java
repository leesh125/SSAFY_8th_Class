package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.model.Note;
import com.ssafy.test.util.DBUtil;

public class NoteDAO {

	private DBUtil dbUtil = DBUtil.getInstance();
	
	public int insertProduct(Note note) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into note(noteCode,model,price,company) values(?,?,?,?)";
		
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, note.getNoteCode());
			pstmt.setString(2, note.getModel());
			pstmt.setInt(3, note.getPrice());
			pstmt.setString(4, note.getCompany());
			int res = pstmt.executeUpdate();
			
			return res;
		}finally {
			dbUtil.close(pstmt,conn);
		}
	}

	public List<Note> getList() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Note> list = new ArrayList<>();
		
		String sql = "select noteCode,model,price,company from note";
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new Note(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
		return list;
	}

	public Note getNote(String noteCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Note note = null;
		
		String sql = "select noteCode,model,price,company from note where notecode=?";
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noteCode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				note = new Note(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4));
			}
			return note;
		}finally {
			dbUtil.close(rs,pstmt,conn);
		}
	}

	public int delete(String noteCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "delete from note where noteCode=?";

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noteCode);
			
			res = pstmt.executeUpdate();
			return res;
		}catch(SQLIntegrityConstraintViolationException e) {
			return 0;
		}finally {
			dbUtil.close(pstmt, conn);
		}
	}

}
