package com.ssafy.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Dept;

public class DeptDAO {

	static final String DRIVER_CLASSNAME = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC";
	static final String DB_USER = "ssafy";
	static final String DB_PASS = "ssafy";
	
	static {
		
		try {
			// step1
			Class.forName(DRIVER_CLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertDept(Dept dept) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		try {
			// step2
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			int rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt+" 행이 처리되었습니다.");
			
			return rowCnt;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return 0;
		
	}
	
	public List<Dept> selectDepts() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dept> list = new ArrayList<Dept>();
		
		String sql = "select deptno,dname,loc from dept";
		try {
			// step2
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			rs = pstmt.executeQuery();
			
			// step5
			
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public Dept selectDept(int deptNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from dept where deptno = ?";
		try {
			// step2
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setInt(1, deptNo);
			Dept dept = (Dept) pstmt.executeQuery();
			System.out.println("조회 완료");
			
			return dept;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public boolean deleteDept(int deptNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from dept where deptno = ?";
		try {
			// step2
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			// step3
			pstmt = conn.prepareStatement(sql);
			
			// step4
			pstmt.setInt(1, deptNo);
			int res = pstmt.executeUpdate();
			System.out.println("조회 완료");
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
