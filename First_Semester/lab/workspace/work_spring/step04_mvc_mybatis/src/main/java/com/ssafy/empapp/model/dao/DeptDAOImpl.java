package com.ssafy.empapp.model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.util.DBUtil;

// Model : DAO (Data Access Logic)
@Repository("deptDao")
public class DeptDAOImpl implements DeptDAO {
	
	@Autowired
	private SqlSession session;
	private static final String Dept_NS = "com.ssafy.empapp.model.dao.DeptDAO";
	
	@Override
	public int insertDept(Dept dept) throws SQLException {
		return session.insert(Dept_NS + ".insertDept", dept);
	}
	
	@Override
	public int updateDept(Dept dept) throws SQLException {
		return session.update(Dept_NS + ".updateDept", dept);
	}
	
	@Override
	public int deleteDept(int deptNo) throws SQLException {
		return session.delete(Dept_NS + ".deleteDept", deptNo);
	}
	
	@Override
	public List<Dept> selectDepts() throws SQLException {
		return session.selectList(Dept_NS + ".selectDepts");
	}
	
	@Override
	public Dept selectDept(int deptNo) throws SQLException {
		return session.selectOne(Dept_NS + ".selectDept", deptNo);
	}
	
	
	
}
