package com.ssafy.empapp.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.util.DBUtil;

@Repository("deptDao")
public class DeptDAOImpl implements DeptDAO {

	@Override
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
			System.out.println(rowCnt+" �뻾�씠 泥섎━�릺�뿀�뒿�땲�떎.");
			
			return rowCnt;
		}finally {
			DBUtil.close(pstmt,conn);
		}
		
		
	}
	
	@Override
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
	
	@Override
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
	
	@Override
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
				System.out.println("�궘�젣 �셿猷�");				
			}else {
				System.out.println("遺��꽌 踰덊샇媛� �뾾�뼱�꽌 �궘�젣 紐삵븿");
			}
			
			return true;
		}finally {
			DBUtil.close(pstmt,conn);
		}
	}

	@Override
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
