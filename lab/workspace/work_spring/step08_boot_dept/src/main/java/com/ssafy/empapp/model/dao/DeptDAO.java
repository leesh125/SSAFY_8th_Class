package com.ssafy.empapp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Dept;

@Mapper
public interface DeptDAO {

	int insertDept(Dept dept);

	List<Dept> selectDepts(Map<String,Object> conditions);

	Dept selectDept(int deptno);

	int updateDept(Dept dept) ;

	int deleteDept(int deptNo) ;

	Dept selectDeptWithEmps(int deptno);
}