package com.ssafy.empapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Emp;

@Mapper
public interface EmpDAO {

//	void deleteEmps(Map<String,Object> map);
	int deleteEmps(int[] empNos);
	
	List<Emp> selectEmpsByDeptno(int deptNo);

	int insertEmp(Emp emp);

	List<Emp> selectEmps();

	Emp selectEmp(int empno);

	int updateEmp(Emp emp);
}
