package com.ssafy.sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
