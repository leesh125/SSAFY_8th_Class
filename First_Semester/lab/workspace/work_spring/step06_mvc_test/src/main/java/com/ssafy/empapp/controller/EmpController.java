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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/emps")
@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping
	protected ResponseEntity<List<Emp>> getEmpList() throws Exception {

		return ResponseEntity.ok(empService.getEmps());
	}
	
	/*
	 * @RequestMapping("/rest/list.do")
	 * 
	 * @ResponseBody protected List<Emp> getEMpRestList() throws Exception { return
	 * empService.getEmps(); }
	 */
	
	@PostMapping
	protected ResponseEntity<?> register(@RequestBody Emp emp) throws Exception {
		
		log.info("register emp");
		boolean res = empService.registerEmp(emp);
		
		// 4. view page by result
		if(res) {
			return ResponseEntity.created(URI.create("api/emps/" + emp.getEmpno())).build();
		}else {			
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping("/{empno}")
	protected ResponseEntity<?> getDeptDetailWithEmps(@PathVariable int empno) {
		
		Emp emp = empService.getDeptWithEmp(empno);
		log.info(emp.toString());
		if(emp != null) {
			return ResponseEntity.ok().body(emp);
		}else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{empno}")
	protected ResponseEntity<?> modify(@RequestBody Emp emp) {
		Emp emp2 = empService.getEmp(emp.getEmpno());
		
		if(emp2 != null) {
			boolean res = empService.modifyEmp(emp);
			
			if(res) {
				return ResponseEntity.ok().body(emp);
			}else {
				return ResponseEntity.internalServerError().build();
			}
			
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{empno}")
	protected ResponseEntity<?> remove(@PathVariable int empno) throws Exception {
		
		Emp emp2 = empService.getEmp(empno);
		
		if(emp2 != null) {
			boolean res = empService.deleteEmp(empno);
			
			if(res) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.internalServerError().build();
			}
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/delete.do")
	public String deleteEmps(@RequestParam(required = false) int[] empno) {
		if(empno != null) empService.deleteEmps(empno);
		return "redirect:/index.do";
	}	

}
