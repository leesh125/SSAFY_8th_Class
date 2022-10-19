package com.ssafy.empapp.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptDAO {

	int insertDept(Dept dept) throws SQLException;

	List<Dept> selectDepts() throws SQLException;

	Dept selectDept(int deptNo) throws SQLException;

	boolean deleteDept(int deptNo) throws SQLException;

	int updateDept(int deptno, String dname, String loc) throws SQLException;

}