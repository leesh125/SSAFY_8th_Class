package com.ssafy.empapp.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.DeptDAO;
import com.ssafy.empapp.model.dto.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	
	@Autowired
	public DeptServiceImpl(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public boolean registerDept(Dept dept) throws SQLException {
		// 遺��꽌 �벑濡�
		return deptDao.insertDept(dept) > 0;
	}
	
	@Override
	public List<Dept> getDepts() throws SQLException {
		// 遺��꽌由ъ뒪�듃 議고쉶
		return deptDao.selectDepts();
	}

	@Override
	public Dept getDept(int deptno) throws SQLException {
		// 遺��꽌 議고쉶
		return deptDao.selectDept(deptno);
	}
	
	@Override
	public boolean deleteDept(int deptno) throws SQLException {
		// 遺��꽌 �궘�젣
		return deptDao.deleteDept(deptno);
	}

	@Override
	public int updateDept(int deptno, String dname, String loc) throws SQLException {
		return deptDao.updateDept(deptno, dname, loc);
	}
}
