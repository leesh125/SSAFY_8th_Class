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
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	
	@RequestMapping("/list.do")
	protected String getDeptList(Model model) throws Exception {

		List<Dept> depts = deptService.getDepts();
		model.addAttribute("deptList", depts); // request 보관함에 저장됨

		return "dept/list";
	}

	
//	화면으로 안주고 데이터로 넘기고 싶다.
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
		mav.setViewName("/dept/detail_form");
		
		return mav;

	}
	
	@RequestMapping("/detail_with_emps.do")
	protected ModelAndView getDeptDetailWithEmps(@RequestParam int deptno) throws Exception {
		Dept dept = deptService.getDEptWithEmps(deptno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dept", dept);
		mav.setViewName("/dept/detail_form_emps");
		
		return mav;
	}
	
	

	
	@GetMapping("/delete.do")
	protected ModelAndView getDeptDelete(int deptno) throws Exception {

		boolean isDeleted = deptService.deleteDept(deptno);

		ModelAndView mav = new ModelAndView();

		if (isDeleted) {
			mav.addObject("msg", "부서 정보 삭제에 성공하였습니다.");
		} else {
			mav.addObject("msg", "부서 정보 삭제에 실패하였습니다.");
		}
		
		mav.setView(new InternalResourceView("/dept/list.do"));
		return mav;

	}

	
//	@PostMapping("/modify.do")
//	protected ModelAndView getDeptModify(Dept dept) throws Exception {
//
//		boolean isUpdated = deptService.updateDept(dept);
//		ModelAndView mav = new ModelAndView();
//
//		if (isUpdated) {
//			mav.addObject("msg", "부서 정보 수정에 성공하였습니다.");
//		} else {
//			mav.addObject("msg", "부서 정보 수정에 실패하였습니다.");
//		}
//		
//		mav.setView(new InternalResourceView("/dept/list.do"));
//		return mav;
//
//	}
	
	@PostMapping("/modify.do")
	protected String getDeptModify(Dept dept, RedirectAttributes rAttributes) throws Exception {

		boolean isUpdated = deptService.updateDept(dept);

		if (isUpdated) {
			rAttributes.addFlashAttribute("msg", "부서 정보 수정에 성공하였습니다.");
		} else {
			rAttributes.addFlashAttribute("msg", "부서 정보 수정에 실패하였습니다.");
		}
		
		return "redirect:/dept/list.do";

	}
	
	
//	@RequestMapping("/register_form.do")
//	protected String registerForm() {
//		return "dept/register_form";
//	}

	
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	protected String getDeptRegister(@RequestParam int deptno, 
			@RequestParam String dname, 
			@RequestParam String loc, 
			Model model) throws Exception {

		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));

		if (res) {
			return "redirect:/dept/list.do"; //얘는 리다이렉트이므로 ViewResolver 안타고 바로 이동한다.
		} else {
			model.addAttribute("errorMsg", "등록에 실패했습니다.");
			return "/dept/register_form";
		}
	}
	
	@ExceptionHandler(Exception.class)
	public String handelException(Exception e, Model model) {
		System.out.println("exception 발생 : " + e.getMessage());
		model.addAttribute("errorMsg", e.getMessage());
		return "error";
	}
	
}
