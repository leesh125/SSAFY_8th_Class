package com.ssafy.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Dept;
import com.ssafy.util.DBUtil;

public class DeptDAO {

	public int insertDept(Dept dept) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		try {
			// step2
			conn = DBUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			int rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt+" 행이 처리되었습니다.");
			
			return rowCnt;
		}finally {
			DBUtil.close(pstmt,conn);
		}
		
		
	}
	
	public List<Dept> selectDepts() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		String sql = "select deptno,dname,loc from dept";
		try {
			// step2
			conn = DBUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			rs = pstmt.executeQuery();
			
			// step5
			
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		}finally {
			DBUtil.close(rs,pstmt,conn);
		}
		return list;
	}
	
	public Dept selectDept(int deptNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = null;
		String sql = "select deptno,dname,loc from dept where deptno = ?";
		try {
			// step2
			conn = DBUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptNo);
			// step4
			rs = pstmt.executeQuery();
			
			// step5
			
			while (rs.next()) {
				dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
			
			return dept;
		} finally {
			DBUtil.close(rs,pstmt,conn);
		}
	}
	
	public boolean deleteDept(int deptNo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from dept where deptno = ?";
		try {
			// step2
			conn = DBUtil.getConnection();
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setInt(1, deptNo);
			int res = pstmt.executeUpdate();
			if(res == 1) {
				System.out.println("삭제 완료");				
			}else {
				System.out.println("부서 번호가 없어서 삭제 못함");
			}
			
			return true;
		}finally {
			DBUtil.close(pstmt,conn);
		}
	}

	public int updateDept(int deptno, String dname, String loc) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Dept dept = selectDept(deptno);
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		try {
			// step2
			conn = DBUtil.getConnection();	
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			return pstmt.executeUpdate();

		}finally {
			DBUtil.close(pstmt,conn);
		}
	}
	
}
