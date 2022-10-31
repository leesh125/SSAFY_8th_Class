package com.ssafy.empapp.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Dept;

@Mapper
public interface DeptDAO {

	int insertDept(Dept dept);

	List<Dept> selectDepts();

	Dept selectDept(int deptno);

	int updateDept(Dept dept) ;

	int deleteDept(int deptNo) ;

	Dept selectDeptWithEmps(int deptno);

	List<Dept> searchSelectDepts(HashMap<String, String> map);
}