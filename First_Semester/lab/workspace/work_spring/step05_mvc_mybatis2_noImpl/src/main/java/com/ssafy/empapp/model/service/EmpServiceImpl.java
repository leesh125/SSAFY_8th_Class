package com.ssafy.empapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.empapp.model.dao.EmpDAO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO empDao;
	
	/*
	 * @Override public void deleteEmps(int[] empNos) { HashMap<String, Object> map
	 * = new HashMap<String, Object>(); map.put("array",empNos);
	 * empDao.deleteEmps(map);
	 * 
	 * }
	 */
	
	@Override
	public void deleteEmps(int[] empNos) {
		empDao.deleteEmps(empNos);
	}

}
