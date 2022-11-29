package com.ssafy.empapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Dept;

@Mapper
public interface DeptDAO {

	int insertDept(Dept dept);


	List<Dept> selectDepts();

	//	부서 번호 주면 
	Dept selectDept(int deptNo);

	boolean updateDept(Dept dept);
	
	//	부서 번호 받아서 삭제하기
	boolean deleteDept(int deptNo);
	
	Dept selectDeptWithEmps(int deptno);
}