package com.ssafy.empapp.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept) throws SQLException;

	List<Dept> getDepts() throws SQLException;

	Dept getDept(int deptno) throws SQLException;

	boolean deleteDept(int deptno) throws SQLException;

	int updateDept(int deptno, String dname, String loc) throws SQLException;

}