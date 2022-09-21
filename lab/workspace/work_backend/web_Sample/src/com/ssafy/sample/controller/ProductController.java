package com.ssafy.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.PageInfo;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.model.service.ProductService;

public class ProductController implements Controller {

	private ProductService productService = new ProductService();
	
	@Override
	public Object handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url = request.getServletPath();
		
		if(url.equals("/product/register.do")) {
			return insertProduct(request, response);
		}else if(url.equals("/product/list.do")) {
			return getProducts(request, response);
		}else if(url.equals("/product/detail.do")) {
			return getProduct(request, response);
		}else if(url.equals("/product/modify.do")) {
			return null;
		}else if(url.equals("/product/delete.do")) {
			return null;
		}
		return null;
	}
	
	protected PageInfo insertProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		String model = request.getParameter("model");
		int price = Integer.parseInt(request.getParameter("price"));
		
		boolean res = productService.insertProduct(new Product(code,model,price));
		
		if(res) {
			return new PageInfo(false, "/product/list.do");
		}else {
			request.setAttribute("errorMsg", "상품 등록에 실패하였습니다.");
			return new PageInfo(true, "/product/regiter.jsp");
		}
	}
	
	protected PageInfo getProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> products = productService.getLists();
		request.setAttribute("products", products);
		return new PageInfo(true, "/product/list.jsp");
	}
	
	protected PageInfo getProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("code");
		Product product = productService.getProduct(code);
		request.setAttribute("product", product);
		return new PageInfo(true, "/product/detail.jsp");
	}

}
