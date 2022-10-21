package com.ssafy.empapp.model.service;

import java.util.List;

import com.ssafy.empapp.model.dto.Dept;

public interface DeptService {

	boolean registerDept(Dept dept) throws Exception;

	List<Dept> getDepts() throws Exception;

	Dept getDept(int deptno) throws Exception;

	boolean deleteDept(int deptno) throws Exception;

	boolean updateDept(Dept dept) throws Exception;

}