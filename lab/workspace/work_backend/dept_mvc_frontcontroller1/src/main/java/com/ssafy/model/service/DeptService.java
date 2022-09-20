package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

public class DeptService {

	private DeptDAO deptDao = new DeptDAO();
	
	public boolean registerDept(Dept dept) throws SQLException {
		// 부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	
	public List<Dept> getDepts() throws SQLException {
		// 부서리스트 조회
		return deptDao.selectDepts();
	}

	public Dept getDept(int deptno) throws SQLException {
		// 부서 조회
		return deptDao.selectDept(deptno);
	}
	
	public boolean deleteDept(int deptno) throws SQLException {
		// 부서 삭제
		return deptDao.deleteDept(deptno);
	}

	public int updateDept(int deptno, String dname, String loc) throws SQLException {
		return deptDao.updateDept(deptno, dname, loc);
	}
}
