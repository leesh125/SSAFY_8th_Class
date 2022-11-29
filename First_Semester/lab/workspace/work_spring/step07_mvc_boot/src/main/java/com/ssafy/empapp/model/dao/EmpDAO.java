package com.ssafy.empapp.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.empapp.model.dto.Emp;

@Mapper
public interface EmpDAO {

	int insertEmp(Emp emp);

	List<Emp> selectEmps();

	Emp selectEmp(int empno);
	
	void deleteEmps(int[] empNos);
	
	Emp selectEmpWithDept(int empno);

	int deleteEmp(int empno);

	int updateEmp(Emp emp);
}
