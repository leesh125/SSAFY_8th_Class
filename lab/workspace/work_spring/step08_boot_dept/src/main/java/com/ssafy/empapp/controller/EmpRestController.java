package com.ssafy.empapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

@RequestMapping("/api/emps")
@RestController
public class EmpRestController {
	
	@Autowired
	private EmpService empService;
	
	@DeleteMapping
	public ResponseEntity<?> deleteEmps(@RequestParam(required = false) int[] empno) {
		if(empno != null) empService.deleteEmps(empno);
		return ResponseEntity.noContent().build();
	}	
	@GetMapping
	public ResponseEntity<List<Emp>> getEmps(@RequestParam(required = false) Integer deptno) {
		List<Emp> emps = null;
		
		if(deptno == null) {
			emps = empService.getEmps();			
		}else {
			emps = empService.getEmpsByDeptNo(deptno);
		}
		return ResponseEntity.ok().body(emps);
	}	
	
	@GetMapping("/{empno}")
	public ResponseEntity<?> getEmp(@PathVariable int empno) {
		Emp emp = empService.getEmp(empno);
		if(emp == null) {
			return ResponseEntity.notFound().build();		
		}else {
			return ResponseEntity.ok().body(emp);
		}
	}	

	@PostMapping
	protected ResponseEntity<?> register(@RequestBody Emp emp)  {
		
		boolean res = empService.registerEmp(emp);
		
		// 4. view page by result
		if(res) {
			return ResponseEntity.created(URI.create("/api/emps/"+emp.getEmpno())).build();
		}else {			
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PutMapping("/{empno}")
	protected ResponseEntity<?> modify(@RequestBody Emp emp) {
		
		Emp emp2 = empService.getEmp(emp.getEmpno());
		if(emp2 != null) {
			boolean res = empService.modifyEmp(emp);
			if(res) {
				return ResponseEntity.ok(emp);
			}else {
				return ResponseEntity.internalServerError().build();
			}
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
