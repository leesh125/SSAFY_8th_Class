package com.ssafy.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import com.ssafy.empapp.model.service.DeptService;

@RequestMapping("/dept")
@Controller
public class DeptController  {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("/list.do")
	protected String getDeptList(Model model) throws Exception {

		List<Dept> depts = deptService.getDepts();
		model.addAttribute("deptList", depts); // request 보관함에 저장

		return "dept/list";
	}
	
	@RequestMapping("/rest/list.do")
	@ResponseBody
	protected List<Dept> getDeptRestList() throws Exception {
		
		return deptService.getDepts();
	}
	
	@RequestMapping("/detail.do")
	protected ModelAndView getDeptDetail(@RequestParam int deptno) throws Exception {

		Dept dept = deptService.getDept(deptno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept", dept);
		mav.setViewName("dept/detail_form");
		return mav;
	}
	@RequestMapping("/detail_with_emps.do")
	protected ModelAndView getDeptDetailWithEmps(@RequestParam int deptno) throws Exception {
		
		Dept dept = deptService.getDeptWithEmps(deptno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept", dept);
		mav.setViewName("dept/detail_form_emps");
		return mav;
	}


	@RequestMapping(value = "/register.do",method = RequestMethod.POST)
	protected String register(@RequestParam int deptno,@RequestParam String dname,@RequestParam String loc,Model model) throws Exception {
		
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		
		// 4. view page by result
		if(res) {
			return "redirect:/dept/list.do";
		}else {			
			model.addAttribute("errorMsg", "등록에 실패하였습니다.");
			return "dept/register_form";
		}
	}

//	@PostMapping("/modify.do")
//	protected ModelAndView modify(Dept dept) throws Exception {
//		
//		// 2. call Model(Service)
//		boolean res = deptService.modifyDept(dept);
//		
//		ModelAndView mav = new ModelAndView();
//		// 3. move page by result
//		if(res) {
//			mav.addObject("msg", "부서 수정에 성공하였습니다.");
//		}else {
//			mav.addObject("msg", "부서 수정에 실패하였습니다.");			
//		}
//		mav.setView(new InternalResourceView("/dept/list.do"));
////		mav.setViewName("/dept/list.do"); // /WEB-INF/views//dept/list.do.jsp
//		return mav;
//	}
	@PostMapping("/modify.do")
	protected String modify(Dept dept,RedirectAttributes rAttributes) throws Exception {
		
		// 2. call Model(Service)
		boolean res = deptService.modifyDept(dept);
		
		// 3. move page by result
		if(res) {
//			rAttributes.addAttribute("msg", "부서 수정에 성공하였습니다.");
			rAttributes.addFlashAttribute("msg", "부서 수정에 성공하였습니다.");
		}else {
//			rAttributes.addAttribute("msg", "부서 수정에 실패하였습니다.");
			rAttributes.addFlashAttribute("msg", "부서 수정에 실패하였습니다.");
		}
		return "redirect:/dept/list.do";
	}
	
	@GetMapping("/remove.do")
	protected ModelAndView remove(int deptno) throws Exception {
		
		boolean res = deptService.deleteDept(deptno);
		
		ModelAndView mav = new ModelAndView();
		// 3. move page by result
		if(res) {
			mav.addObject("msg", "부서 삭제에 성공하였습니다.");
		}else {
			mav.addObject("msg", "부서 삭제에 실패하였습니다.");			
		}
		mav.setView(new InternalResourceView("/dept/list.do"));
		return mav;
	}
	
	@GetMapping("/search.do")
	protected String getDeptList(@RequestParam String dname,@RequestParam String loc, Model model) throws Exception {
		
		List<Dept> depts = deptService.getDepts(dname, loc);
		model.addAttribute("deptList", depts); // request 보관함에 저장

		return "dept/list";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e,Model model) {
		System.out.println("exception 발생 : "+e.getMessage());
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
	
	
}
