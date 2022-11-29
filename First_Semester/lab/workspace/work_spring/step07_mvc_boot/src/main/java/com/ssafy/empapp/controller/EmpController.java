package com.ssafy.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.dto.Emp;
import com.ssafy.empapp.model.service.EmpService;

@RequestMapping("/emp")
@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/list.do")
	protected String getEmpList(Model model) throws Exception {

		List<Emp> emps = empService.getEmps();
		model.addAttribute("empList", emps); // request 보관함에 저장
		
		return "emp/list";
	}
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Emp> getEMpRestList() throws Exception {
		return empService.getEmps();
	}
	
	@RequestMapping(value = "/register.do",method = RequestMethod.POST)
	protected String register(@RequestParam int empno,@RequestParam String ename,@RequestParam String job,@RequestParam double sal,@RequestParam int deptno,Model model) throws Exception {
		
		boolean res = empService.registerEmp(new Emp(empno, ename, job, sal, deptno));
		
		// 4. view page by result
		if(res) {
			return "redirect:/emp/list.do";
		}else {			
			model.addAttribute("errorMsg", "등록에 실패하였습니다.");
			return "emp/register_form";
		}
	}
	
	@RequestMapping("/detail_with_dept.do")
	protected ModelAndView getDeptDetailWithEmps(@RequestParam int empno) throws Exception {
		
		Emp emp = empService.getDeptWithEmp(empno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp", emp);
		mav.setViewName("emp/detail_form_dept");
		return mav;
	}
	
	@PostMapping("/modify.do")
	protected String modify(Emp emp,RedirectAttributes rAttributes) throws Exception {
		
		// 2. call Model(Service)
		boolean res = empService.modifyEmp(emp);
		
		// 3. move page by result
		if(res) {
//			rAttributes.addAttribute("msg", "부서 수정에 성공하였습니다.");
			rAttributes.addFlashAttribute("msg", "사원 수정에 성공하였습니다.");
		}else {
//			rAttributes.addAttribute("msg", "부서 수정에 실패하였습니다.");
			rAttributes.addFlashAttribute("msg", "사원 수정에 실패하였습니다.");
		}
		return "redirect:/emp/list.do";
	}
	
	@GetMapping("/remove.do")
	protected ModelAndView remove(int empno) throws Exception {
		
		boolean res = empService.deleteEmp(empno);
		
		ModelAndView mav = new ModelAndView();
		// 3. move page by result
		if(res) {
			mav.addObject("msg", "사원 삭제에 성공하였습니다.");
		}else {
			mav.addObject("msg", "사원삭제에 실패하였습니다.");			
		}
		mav.setView(new InternalResourceView("/emp/list.do"));
		return mav;
	}
	
	@PostMapping("/delete.do")
	public String deleteEmps(@RequestParam(required = false) int[] empno) {
		if(empno != null) empService.deleteEmps(empno);
		return "redirect:/index.do";
	}	

}
