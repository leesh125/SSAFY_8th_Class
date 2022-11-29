package com.ssafy.empapp.controller.exception.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception e, Model model) {
		model.addAttribute("errorMsg", e.getMessage());
		return "global_error";
	}
}
