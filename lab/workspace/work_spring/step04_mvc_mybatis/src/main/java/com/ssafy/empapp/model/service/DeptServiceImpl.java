package com.ssafy.empapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

// Model : B/L
@Service
public class DeptServiceImpl implements DeptService {
	
	private DeptDAO deptDao;
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao = deptDao;
	} // 생성자 주입

	
	@Override
	public boolean registerDept(Dept dept) throws Exception{
		// 부서 등록
		return deptDao.insertDept(dept) > 0;
	}
	
	@Override
	public List<Dept> getDepts() throws Exception{
		// 부서리스트 조회
		return deptDao.selectDepts();
	}

	@Override
	public Dept getDept(int deptno) throws Exception{
		// 부서 상세 조회
		return deptDao.selectDept(deptno);
	}
	
	@Override
	public boolean deleteDept(int deptno) throws Exception{
		// 부서 상세 조회
		return deptDao.deleteDept(deptno) > 0;
	}
	
	@Override
	public boolean updateDept(Dept dept) throws Exception{
		// 부서 정보 갱신
		return deptDao.updateDept(dept)> 0;
	}
}
