package com.ssafy.empapp.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.EmpDAO;
import com.ssafy.empapp.model.dto.Emp;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDao;
	
//	@Override
//	public void deleteEmps(int[] empNos) {
//		HashMap<String,Object> map = new HashMap<String,Object>();
//		map.put("array", empNos);
//		empDao.deleteEmps(map);
//	}
	@Override
	public void deleteEmps(int[] empNos) {
		empDao.deleteEmps(empNos);
	}

	@Override
	public List<Emp> getEmps() {
		return empDao.selectEmps();
	}

	@Override
	public boolean registerEmp(Emp emp) {
		return empDao.insertEmp(emp) > 0;
	}

	@Override
	public Emp getEmp(int empno) {
		return empDao.selectEmp(empno);
	}

	@Override
	public Emp getDeptWithEmp(int empno) {
		return empDao.selectEmpWithDept(empno);
	}

	@Override
	public boolean deleteEmp(int empno) {
		return empDao.deleteEmp(empno) > 0;
	}

	@Override
	public boolean modifyEmp(Emp emp) {
		return empDao.updateEmp(emp) > 0;
	}

}













