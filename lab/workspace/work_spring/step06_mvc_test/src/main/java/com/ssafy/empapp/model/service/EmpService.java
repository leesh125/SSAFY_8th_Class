package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Emp;

public interface EmpService {
	
	boolean registerEmp(Emp emp);

	Emp getEmp(int empno);
	
	void deleteEmps(int[] empNos);

	List<Emp> getEmps();

	Emp getDeptWithEmp(int empno);

	boolean deleteEmp(int empno);

	boolean modifyEmp(Emp emp);
}
