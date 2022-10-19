package com.ssafy.empapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ssafy.empapp.model.dto.Dept;
import com.ssafy.empapp.model.service.DeptService;

@RequestMapping("/dept")
@Controller
public class DeptController{

	@Autowired
	private DeptService deptService;
	
//	@Override
//	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		String url = request.getServletPath();
//		
//		if(url.equals("/dept/list.do")) {
//			return getDeptList(request, response);
//		}else if(url.equals("/dept/detail.do")) {
//			return getDeptDetail(request, response);
//		}else if(url.equals("/dept/delete.do")) {
//			return deptDelete(request, response);
//		}else if(url.equals("/dept/modify.do")) {
//			return deptModify(request, response);
//		}else if(url.equals("/dept/register.do")) {
//			return deptRegister(request, response);
//		}else if(url.equals("/dept/rest/list.do")) {
//			return deptRegister(request, response);
//		}
//		return null;
//	}
	
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
		ModelAndView mv = new ModelAndView();
		mv.addObject("dept", dept);
		mv.setViewName("dept/detail_form");
		
		return mv;
	}
	
	@RequestMapping("/register_form.do")
	protected String registerForm() {
		return "dept/register_form";
	}
	
	@PostMapping("/register.do")
	protected String deptRegister(@RequestParam int deptno,@RequestParam String dname,@RequestParam String loc,Model model) throws Exception {
		
		boolean res = deptService.registerDept(new Dept(deptno, dname, loc));
		
		if(res) {
			return "redirect:/dept/list.do";
		}else {
			model.addAttribute("errorMsg","등록에 실패하였습니다.");
			return "/dept/register_form";
		}
	}
	
	@PostMapping("/modify.do")
	protected ModelAndView deptModify(Dept dept) throws Exception {
		
		int res = deptService.updateDept(dept.getDeptNo(), dept.getDname(), dept.getLoc());
		
		ModelAndView mv = new ModelAndView();
		
		if(res != -1) {
			mv.addObject("msg", "부서 수정에 성공하였습니다.");
		}else {
			mv.addObject("msg", "부서 수정에 성공하였습니다.");
		}
		mv.setView(new InternalResourceView("/dept/list.do"));
		return mv;
	}
	

	@GetMapping("/delete.do")
	protected ModelAndView deptDelete(int deptno) throws Exception {
		
		boolean isDeleted = deptService.deleteDept(deptno);
		ModelAndView mv = new ModelAndView();
		if(isDeleted) {
			mv.addObject("msg", "부서 수정에 성공하였습니다.");
		}else {
			mv.addObject("msg", "부서 수정에 성공하였습니다.");
		}
		mv.setView(new InternalResourceView("/dept/list.do"));
		return mv;
	}
}
