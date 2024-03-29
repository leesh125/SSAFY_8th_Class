package com.ssafy.empapp.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Dept;


public interface DeptDAO {

	int insertDept(Dept dept) throws SQLException;

	int updateDept(Dept dept) throws SQLException;

	List<Dept> selectDepts() throws SQLException;

	//	부서 번호 주면 
	Dept selectDept(int deptNo) throws SQLException;

	//	부서 번호 받아서 삭제하기
	int deleteDept(int deptNo) throws SQLException;

}