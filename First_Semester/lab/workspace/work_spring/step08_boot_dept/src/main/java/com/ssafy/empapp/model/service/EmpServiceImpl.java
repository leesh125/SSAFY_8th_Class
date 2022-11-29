package com.ssafy.empapp.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.empapp.model.dao.EmpDAO;
import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.dto.Emp;

//@Transactional
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
		if(empDao.deleteEmps(empNos) != empNos.length) throw new RuntimeException("삭제에 실패하였습니다.") ;
	}

	@Override
	public List<Emp> getEmpsByDeptNo(int deptNo) {
		return empDao.selectEmpsByDeptno(deptNo);
	}

	@Override
	public boolean registerEmp(Emp emp) {
		// 부서 등록
		return empDao.insertEmp(emp) > 0 ;
//		return deptDao.insertDept(dept) > 0 && deptDao.insertDept(dept) > 0;
	}

	@Override
	public List<Emp> getEmps() {
		return empDao.selectEmps();
	}

	@Override
	public Emp getEmp(int empno) {
		return empDao.selectEmp(empno);
	}

	@Override
	public boolean modifyEmp(Emp emp) {
		return empDao.updateEmp(emp) > 0;
	}

}













